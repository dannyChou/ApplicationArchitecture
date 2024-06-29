class AbstractMapper...

    protected DomainObjectEL load(ResultSet rs) throws SQLException {
        Long id = new Long(rs.getLong(1));
        if (loadedMap.containsKey(id)) return (DomainObjectEL) loadedMap.get(id);
        DomainObjectEL result = createDomainObject();
        result.setID(id);
        loadedMap.put(id, result);
        doLoad (result, rs);
        return result;
    }
    abstract protected DomainObjectEL createDomainObject();
    abstract protected void doLoad(DomainObjectEL obj, ResultSet rs) throws SQLException;

class PersonMapper...

    protected DomainObjectEL createDomainObject() {
        return new Person();
    }
    protected void doLoad(DomainObjectEL obj, ResultSet rs) throws SQLException {
        Person person = (Person) obj;
        person.dbLoadLastName(rs.getString(2));
        person.setFirstName(rs.getString(3));
        person.setNumberOfDependents(rs.getInt(4));
    }