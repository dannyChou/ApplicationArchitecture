class TrackMapper...

    public static final String findForAlbumStatement =
        "SELECT ID, seq, albumID, title " +
        "FROM tracks " +
        "WHERE albumID = ? ORDER BY seq";
    public List findForAlbum(Long albumID) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = DB.prepare(findForAlbumStatement);
            stmt.setLong(1, albumID.longValue());
            rs = stmt.executeQuery();
            List result = new ArrayList();
            while (rs.next())
                result.add(load(rs));
            return result;
        } catch (SQLException e) {
            throw new ApplicationException(e);
        } finally {
            cleanUp(stmt, rs);
        }
    }