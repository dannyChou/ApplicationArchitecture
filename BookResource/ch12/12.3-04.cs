class AbstractMapper...

    protected DomainObject Load (DataRow row) {
        long id = (int) row ["id"];
        if (identityMap[id] != null) return (DomainObject) identityMap[id];
        else {
            DomainObject result = CreateDomainObject();
            result.Id = id;
            identityMap.Add(result.Id, result);
            doLoad(result,row);
            return result;
        }
    }
    abstract protected DomainObject CreateDomainObject();
    private IDictionary identityMap = new Hashtable();
    abstract protected void doLoad (DomainObject obj, DataRow row);

class EmployeeMapper...

    protected override void doLoad (DomainObject obj, DataRow row) {
        Employee emp = (Employee) obj;
        emp.Name = (String) row["name"];
        loadSkills(emp);
    }