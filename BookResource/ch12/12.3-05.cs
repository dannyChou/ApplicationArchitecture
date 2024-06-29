class EmployeeMapper...

    private IList loadSkills (Employee emp) {
        DataRow[] rows = skillLinkRows(emp);
        IList result = new ArrayList();
        foreach (DataRow row in rows) {
            long skillID = (int)row["skillID"];
            emp.AddSkill(MapperRegistry.Skill.Find(skillID));
        }
        return result;
    }
    private DataRow[] skillLinkRows(Employee emp) {
        String filter = String.Format("employeeID = {0}", emp.Id);
        return skillLinkTable.Select(filter);
    }
    private DataTable skillLinkTable {
        get {return dsh.Data.Tables["skillEmployees"];}
    }