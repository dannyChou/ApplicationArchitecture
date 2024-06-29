class AlbumMapper...

    protected DomainObject doLoad(Long id, ResultSet rs) throws SQLException {
        String title = rs.getString(2);
        long artistID = rs.getLong(3);
        ArtistMapper artistMapper = MapperRegistry.artist();
        Artist artist;
        if (artistMapper.isLoaded(artistID))
            artist = artistMapper.find(artistID);
        else
            artist = loadArtist(artistID, rs);
        Album result = new Album(id, title, artist);
        return result;
    }
    private Artist loadArtist(long id, ResultSet rs) throws SQLException {
        String name = rs.getString(4);
        Artist result = new Artist(new Long(id), name);
        MapperRegistry.artist().register(result.getID(), result);
        return result;
    }