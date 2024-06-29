class Customer...

    public static Customer load(ResultSet rs) throws SQLException {
        Long id = new Long(rs.getLong("id"));
        Customer result = (Customer) Registry.getCustomer(id);
        if (result != null) return result;
        String name = rs.getString("name");
        String departmentLob = rs.getString("departments");
        result = new Customer(name);
        result.readDepartments(XmlStringer.read(departmentLob));
        return result;
    }
    void readDepartments(Element source) {
        List result = new ArrayList();
        Iterator it = source.getChildren("department").iterator();
        while (it.hasNext())
            addDepartment(Department.readXml((Element) it.next()));
    }

class Department...

    static Department readXml(Element source) {
        String name = source.getAttributeValue("name");
        Department result = new Department(name);
        Iterator it = source.getChildren("department").iterator();
        while (it.hasNext())
            result.addSubsidiary(readXml((Element) it.next()));
        return result;
    }