class EmployeeMapper...

    public List findAll() {
        return findAll(findAllStatement);
    }
    private static final String findAllStatement =
        "SELECT " + COLUMN_LIST +
        " FROM employees employee, skills skill, employeeSkills es" +
        " WHERE employee.ID = es.employeeID AND skill.ID = es.skillID" +
        " ORDER BY employee.lastname";
    protected List findAll(String sql) {
        AssociationTableLoader loader = new AssociationTableLoader(this, new SkillAdder());
        return loader.run(findAllStatement);
    }

class AssociationTableLoader...

    private AbstractMapper sourceMapper;
    private Adder targetAdder;
    public AssociationTableLoader(AbstractMapper primaryMapper, Adder targetAdder) {
        this.sourceMapper = primaryMapper;
        this.targetAdder = targetAdder;
    }
