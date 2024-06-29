class Version...

    public static Version create() {
        Version version = new Version(IdGenerator.INSTANCE.nextId(), 0,
            AppSessionManager.getSession().getUser(), now());
        version.isNew = true;
        return version;
    }
    public void insert() {
        if (isNew()) {
        Connection conn = null;
        PreparedStatement pstmt = null;
            try {
                conn = ConnectionManager.INSTANCE.getConnection();
                pstmt = conn.prepareStatement(INSERT_SQL);
                pstmt.setLong(1, this.getId().longValue());
                pstmt.setLong(2, this.getValue());
                pstmt.setString(3, this.getModifiedBy());
                pstmt.setTimestamp(4, this.getModified());
                pstmt.executeUpdate();
                AppSessionManager.getSession().getIdentityMap().putVersion(this);
                isNew = false;
            } catch (SQLException sqlEx) {
                throw new SystemException("unexpected sql error inserting version", sqlEx);
            } finally {
                cleanupDBResources(conn, pstmt);
            }
        }
    }