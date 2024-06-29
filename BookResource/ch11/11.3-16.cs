class EmployeeMapper...

    public Employee Find (long key) {
        return (Employee) AbstractFind(key);
    }

class Mapper...

    public DomainObject AbstractFind (long key) {
        DomainObject result;
        result = (DomainObject) loadedMap[key];
        if (result == null) {
            result = CreateGhost(key);
            loadedMap.Add(key, result);
        }
        return result;
    }
    IDictionary loadedMap = new Hashtable();
    public abstract DomainObject CreateGhost(long key);

class EmployeeMapper...

    public override DomainObject CreateGhost(long key) {
        return new Employee(key);
    }