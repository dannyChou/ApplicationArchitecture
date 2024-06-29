class EmployeeMapper...

    protected List loadSkills(Long employeeID) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            List result = new ArrayList();
            stmt = DB.prepare(findSkillsStatement);
            stmt.setObject(1, employeeID);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Long skillId = new Long (rs.getLong(1));
                result.add((Skill) MapperRegistry.skill().loadRow(skillId, rs));
            }
            return result;
        } catch (SQLException e) {
            throw new ApplicationException(e);
        } finally {DB.cleanUp(stmt, rs);
        }
    }
    private static final String findSkillsStatement =
        "SELECT skill.ID, " + SkillMapper.COLUMN_LIST +
        " FROM skills skill, employeeSkills es " +
        " WHERE es.employeeID = ? AND skill.ID = es.skillID";

class SkillMapper...

    public static final String COLUMN_LIST = " skill.name skillName ";

class AbstractMapper...

    protected DomainObject loadRow (Long id, ResultSet rs) throws SQLException {
        return load (id, rs);
    }

class SkillMapper...

    protected DomainObject doLoad(Long id, ResultSet rs) throws SQLException {
        Skill result = new Skill (id);
        result.setName(rs.getString("skillName"));
        return result;
    }