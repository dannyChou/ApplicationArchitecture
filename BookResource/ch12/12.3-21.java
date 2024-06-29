class EmployeeMapper...

    private static class SkillAdder implements AssociationTableLoader.Adder {
        public void add(DomainObject host, ResultSet rs) throws SQLException {
            Employee emp = (Employee) host;
            Long skillId = new Long (rs.getLong("skillId"));
            emp.addSkill((Skill) MapperRegistry.skill().loadRow(skillId, rs));
        }
    }
