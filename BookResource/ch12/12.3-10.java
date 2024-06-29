class EmployeeMapper...

    public Employee find(long key) {
        return find (new Long (key));
    }
    public Employee find (Long key) {
        return (Employee) abstractFind(key);
    }
    protected String findStatement() {
        return
            "SELECT " + COLUMN_LIST +
            " FROM employees" +
            " WHERE ID = ?";
    }
    public static final String COLUMN_LIST = " ID, lastname, firstname ";

class AbstractMapper...

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
        } finally {DB.cleanUp(stmt, rs);
        }
    }
    abstract protected String findStatement();
    protected Map loadedMap = new HashMap();