class AbstractMapper...

    protected DomainObject load(ResultSet rs) throws SQLException {
        Long id = new Long(rs.getLong(1));
        return load(id, rs);
    }
    public DomainObject load(Long id, ResultSet rs) throws SQLException {
        if (hasLoaded(id)) return (DomainObject) loadedMap.get(id);
        DomainObject result = doLoad(id, rs);
        loadedMap.put(id, result);
        return result;
    }
    abstract protected DomainObject doLoad(Long id, ResultSet rs) throws SQLException;

class EmployeeMapper...

    protected DomainObject doLoad(Long id, ResultSet rs) throws SQLException {
        Employee result = new Employee(id);
        result.setFirstName(rs.getString("firstname"));
        result.setLastName(rs.getString("lastname"));
        result.setSkills(loadSkills(id));
        return result;
    }
