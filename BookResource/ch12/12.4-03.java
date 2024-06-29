class AlbumMapper...

    protected String findStatement() {
        return
            "SELECT ID, a.title, t.title as trackTitle" +
            " FROM albums a, tracks t" +
            " WHERE a.ID = ? AND t.albumID = a.ID" +
            " ORDER BY t.seq";
    }