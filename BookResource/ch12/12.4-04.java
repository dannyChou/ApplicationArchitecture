class AlbumMapper...

    protected DomainObject doLoad(Long id, ResultSet rs) throws SQLException {
        String title = rs.getString(2);
        Album result = new Album(id, title);
        loadTracks(result, rs);
        return result;
    }
    public void loadTracks(Album arg, ResultSet rs) throws SQLException {
        arg.addTrack(newTrack(rs));
        while (rs.next()) {
            arg.addTrack(newTrack(rs));
        }
    }
    private Track newTrack(ResultSet rs) throws SQLException {
        String title = rs.getString(3);
        Track newTrack = new Track (title);
        return newTrack;
    }