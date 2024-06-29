class EmployeeMapper...

    void loadTimeRecords(Employee employee) {
        ListLoader loader = new ListLoader();
        loader.Sql = TimeRecordMapper.FIND_FOR_EMPLOYEE_SQL;
        loader.SqlParams.Add(employee.Key);
        loader.Mapper = MapperRegistry.Mapper(typeof(TimeRecord));
        loader.Attach((DomainList) employee.TimeRecords);
    }

class ListLoader...

    public String Sql;
    public IList SqlParams = new ArrayList();
    public Mapper Mapper;