class AbstractMapper...

    public AbstractMapper(String table, String[] columns) {
        this.table = table;
        this.columns = columns;
        buildStatements();
    }
    public DomainObject find(Long id) {
        DomainObject obj = AppSessionManager.getSession().getIdentityMap().get(id);
        if (obj == null) {
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            try {
                conn = ConnectionManager.INSTANCE.getConnection();
                stmt = conn.prepareStatement(loadSQL);
                stmt.setLong(1, id.longValue());
                rs = stmt.executeQuery();
                if (rs.next()) {
                    obj = load(id, rs);
                    String modifiedBy = rs.getString(columns.length + 2);
                    Timestamp modified = rs.getTimestamp(columns.length + 3);
                    int version = rs.getInt(columns.length + 4);
                    obj.setSystemFields(modified, modifiedBy, version);
                    AppSessionManager.getSession().getIdentityMap().put(obj);
                } else {
                    throw new SystemException(table + " " + id + " does not exist");
                }
            } catch (SQLException sqlEx) {
                throw new SystemException("unexpected error finding " + table + " " + id);
            } finally {
                cleanupDBResources(rs, conn, stmt);
            }
        }
        return obj;
    }
    protected abstract DomainObject load(Long id, ResultSet rs) throws SQLException;