class AbstractMapper...

    abstract protected String findStatement();
    protected Map loadedMap = new HashMap();
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
        } finally {
            cleanUp(stmt, rs);
        }
    }

class ArtistMapper...

    protected String findStatement() {
        return "select " + COLUMN_LIST + " from artists art where ID = ?";
    }
    public static String COLUMN_LIST = "art.ID, art.name";