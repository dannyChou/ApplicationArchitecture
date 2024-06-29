class EmployeeMapper...

    protected override void doLoadLine (IDataReader reader, DomainObject obj) {
        Employee employee = (Employee) obj;
        employee.Name = (String) reader["name"];
        DepartmentMapper depMapper =
            (DepartmentMapper) MapperRegistry.Mapper(typeof(Department));
        employee.Department = depMapper.Find((int) reader["departmentID"]);
        loadTimeRecords(employee);
    }