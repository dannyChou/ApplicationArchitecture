class Version...

    public void increment() throws ConcurrencyException {
        if (!isLocked()) {
            Connection conn = null;
            PreparedStatement pstmt = null;
            try {
                conn = ConnectionManager.INSTANCE.getConnection();
                pstmt = conn.prepareStatement(UPDATE_SQL);
                pstmt.setLong(1, value + 1);
                pstmt.setString(2, getModifiedBy());
                pstmt.setTimestamp(3, getModified());
                pstmt.setLong(4, id.longValue());
                pstmt.setLong(5, value);
                int rowCount = pstmt.executeUpdate();
                if (rowCount == 0) {
                    throwConcurrencyException();
                }
                value++;
                locked = true;
            } catch (SQLException sqlEx) {
                throw new SystemException("unexpected sql error incrementing version", sqlEx);
            } finally {
                cleanupDBResources(conn, pstmt);
            }
        }
    }
    private void throwConcurrencyException() {
        Version currentVersion = load(this.getId());
        throw new ConcurrencyException(
            "version modified by " + currentVersion.modifiedBy + " at " +
            DateFormat.getDateTimeInstance().format(currentVersion.getModified()));
    }