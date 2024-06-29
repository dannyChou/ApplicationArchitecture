class EmployeeMapper...

    protected override void Save (DomainObject obj, DataRow row) {
        Employee emp = (Employee) obj;
        row["name"] = emp.Name;
        saveSkills(emp);
    }