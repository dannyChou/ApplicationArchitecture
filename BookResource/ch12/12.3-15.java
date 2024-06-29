class EmployeeMapper...

    protected DomainObject doLoad(Long id, ResultSet rs) throws SQLException {
        Employee result = (Employee) loadRow(id, rs);
        loadSkillData(result, rs);
        while (rs.next()){
            Assert.isTrue(rowIsForSameEmployee(id, rs));
            loadSkillData(result, rs);
        }
        return result;
    }
    protected DomainObject loadRow(Long id, ResultSet rs) throws SQLException {
        Employee result = new Employee(id);
        result.setFirstName(rs.getString("firstname"));
        result.setLastName(rs.getString("lastname"));
        return result;
    }
    private boolean rowIsForSameEmployee(Long id, ResultSet rs) throws SQLException {
        return id.equals(new Long(rs.getLong(1)));
    }
    private void loadSkillData(Employee person, ResultSet rs) throws SQLException {
        Long skillID = new Long(rs.getLong("skillID"));
        person.addSkill ((Skill)MapperRegistry.skill().loadRow(skillID, rs));
    }
