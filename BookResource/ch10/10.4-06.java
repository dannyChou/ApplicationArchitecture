class AbstractMapper...

    public List findMany(StatementSource source) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = DB.prepare(source.sql());
            for (int i = 0; i < source.parameters().length; i++)
                stmt.setObject(i+1, source.parameters()[i]);
            rs = stmt.executeQuery();
            return loadAll(rs);
        } catch (SQLException e) {
            throw new ApplicationException(e);
        } finally {
            DB.cleanUp(stmt, rs);
        }
    }