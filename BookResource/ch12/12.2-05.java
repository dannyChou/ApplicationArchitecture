class AlbumMapper...

    public Album find(Long id) {
        return (Album) abstractFind(id);
    }
    protected String findStatement() {
        return "SELECT a.ID, a.title, a.artistID, r.name " +
               " from albums a, artists r " +
               " WHERE ID = ? and a.artistID = r.ID";
    }