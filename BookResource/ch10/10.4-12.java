class ArtistMapper implements ArtistFinder...

    public Artist find(Long id) {
        return (Artist) abstractFind(id);
    }
    public Artist find(long id) {
        return find(new Long(id));
    }