class EmployeeMapper...

    public Employee Find(long id) {
        return (Employee) AbstractFind(id);
    }

class AbstractMapper...

    protected DomainObject AbstractFind(long id) {
        Assert.True (id != DomainObject.PLACEHOLDER_ID);
        DataRow row = FindRow(id);
        return (row == null) ? null : Load(row);
    }
    protected DataRow FindRow(long id) {
        String filter = String.Format("id = {0}", id);
        DataRow[] results = table.Select(filter);
        return (results.Length == 0) ? null : results[0];
    }
    protected DataTable table {
        get {return dsh.Data.Tables[TableName];}
    }
    public DataSetHolder dsh;
    abstract protected String TableName {get;}

class EmployeeMapper...

    protected override String TableName {
        get {return "Employees";}
    }