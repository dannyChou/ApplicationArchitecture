class Customer...

    public Long insert() {
        PreparedStatement insertStatement = null;
        try {
            insertStatement = DB.prepare(insertStatementString);
            setID(findNextDatabaseId());
            insertStatement.setInt(1, getID().intValue());
            insertStatement.setString(2, name);
            insertStatement.setString(3, XmlStringer.write(departmentsToXmlElement()));
            insertStatement.execute();
            Registry.addCustomer(this); return getID();
        } catch (SQLException e) {
            throw new ApplicationException(e);
        } finally {DB.cleanUp(insertStatement);
        }
    }
    public Element departmentsToXmlElement() {
        Element root = new Element("departmentList");
        Iterator i = departments.iterator();
        while (i.hasNext()) {
            Department dep = (Department) i.next();
            root.addContent(dep.toXmlElement());
        }
        return root;
    }

class Department...

    Element toXmlElement() {
        Element root = new Element("department");
        root.setAttribute("name", name);
        Iterator i = subsidiaries.iterator();
        while (i.hasNext()) {
            Department dep = (Department) i.next();
            root.addContent(dep.toXmlElement());
        }
        return root;
    }