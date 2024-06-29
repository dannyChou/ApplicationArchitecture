class AlbumMapper...

    public void update(DomainObject arg) {
        PreparedStatement updateStatement = null;
        try {
            updateStatement = DB.prepare("UPDATE albums SET title = ? WHERE id = ?");
            updateStatement.setLong(2, arg.getID().longValue());
            Album album = (Album) arg;
            updateStatement.setString(1, album.getTitle());
            updateStatement.execute();
            updateTracks(album);
        } catch (SQLException e) {
            throw new ApplicationException(e);
        } finally {DB.cleanUp(updateStatement);
        }
    }
    public void updateTracks(Album arg) throws SQLException {
        PreparedStatement deleteTracksStatement = null;
        try {
            deleteTracksStatement = DB.prepare("DELETE from tracks WHERE albumID = ?");
            deleteTracksStatement.setLong(1, arg.getID().longValue());
            deleteTracksStatement.execute();
            for (int i = 0; i < arg.getTracks().length; i++) {
                Track track = arg.getTracks()[i];
                insertTrack(track, i + 1, arg);
            }
        } finally {DB.cleanUp(deleteTracksStatement);
        }
    }
    public void insertTrack(Track track, int seq, Album album) throws SQLException {
        PreparedStatement insertTracksStatement = null;
        try {
            insertTracksStatement =
                DB.prepare("INSERT INTO tracks (seq, albumID, title) VALUES (?, ?, ?)");
            insertTracksStatement.setInt(1, seq);
            insertTracksStatement.setLong(2, album.getID().longValue());
            insertTracksStatement.setString(3, track.getTitle());
            insertTracksStatement.execute();
        } finally {DB.cleanUp(insertTracksStatement);
        }
    }