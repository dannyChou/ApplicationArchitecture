class PersonMapper...

    protected String findStatement() {
        return "SELECT " + COLUMNS +
        " FROM people" +
        " WHERE id = ?";
    }
    public static final String COLUMNS = " id, lastname, firstname, number_of_dependents ";
    public Person find(Long id) {
        return (Person) abstractFind(id);
    }
    public Person find(long id) {
        return find(new Long(id));
    }

class AbstractMapper...

    protected Map loadedMap = new HashMap();
    abstract protected String findStatement();
    protected DomainObject abstractFind(Long id) {
        DomainObject result = (DomainObject) loadedMap.get(id);
        if (result != null) return result;
        PreparedStatement findStatement = null;
        try {
            findStatement = DB.prepare(findStatement());
            findStatement.setLong(1, id.longValue());
            ResultSet rs = findStatement.executeQuery();
            rs.next();
            result = load(rs);
            return result;
        } catch (SQLException e) {
            throw new ApplicationException(e);
        } finally {
            DB.cleanUp(findStatement);
        }
    }