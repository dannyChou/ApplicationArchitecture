class AlbumMapper...

    public Album find(Long id) {
        return (Album) abstractFind(id);
    }
    protected String findStatement() {
        return "SELECT ID, title, artistID FROM albums WHERE ID = ?";
    }

class AbstractMapper...

    abstract protected String findStatement();
    protected DomainObject abstractFind(Long id) {
        DomainObject result = (DomainObject) loadedMap.get(id);
        if (result != null) return result;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = DB.prepare(findStatement());
            stmt.setLong(1, id.longValue());
            rs = stmt.executeQuery();
            rs.next();
            result = load(rs);
            return result;
        } catch (SQLException e) {
            throw new ApplicationException(e);
        } finally {cleanUp(stmt, rs);}
    }
    private Map loadedMap = new HashMap();