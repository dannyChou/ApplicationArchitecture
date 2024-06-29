class EmployeeMapper...

    protected String findStatement() {
        return
            "SELECT " + COLUMN_LIST +
            " FROM employees employee, skills skill, employeeSkills es" +
            " WHERE employee.ID = es.employeeID AND skill.ID = es.skillID AND employee.ID = ?";
    }
    public static final String COLUMN_LIST =
        " employee.ID, employee.lastname, employee.firstname, " +
        " es.skillID, es.employeeID, skill.ID skillID, " +
          SkillMapper.COLUMN_LIST;
