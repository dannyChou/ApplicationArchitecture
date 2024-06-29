class AbstractMapper...

    protected DomainObject load(ResultSet rs) throws SQLException {
        Long id = new Long(rs.getLong("id"));
        if (loadedMap.containsKey(id)) return (DomainObject) loadedMap.get(id);
        DomainObject result = doLoad(id, rs);
        loadedMap.put(id, result);
        return result;
    }
    abstract protected DomainObject doLoad(Long id, ResultSet rs) throws SQLException;

class ArtistMapper...

    protected DomainObject doLoad(Long id, ResultSet rs) throws SQLException {
        String name = rs.getString("name");
        Artist result = new Artist(id, name);
        return result;
    }