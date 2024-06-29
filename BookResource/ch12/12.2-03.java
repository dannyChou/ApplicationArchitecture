class AbstractMapper...

    protected DomainObject load(ResultSet rs) throws SQLException {
        Long id = new Long(rs.getLong(1));
        if (loadedMap.containsKey(id)) return (DomainObject) loadedMap.get(id);
        DomainObject result = doLoad(id, rs);
        doRegister(id, result);
        return result;
    }
    protected void doRegister(Long id, DomainObject result) {
        Assert.isFalse(loadedMap.containsKey(id));
        loadedMap.put(id, result);
    }
    abstract protected DomainObject doLoad(Long id, ResultSet rs) throws SQLException;

class AlbumMapper...

    protected DomainObject doLoad(Long id, ResultSet rs) throws SQLException {
        String title = rs.getString(2);
        long artistID = rs.getLong(3);
        Artist artist = MapperRegistry.artist().find(artistID);
        Album result = new Album(id, title, artist);
        return result;
    }