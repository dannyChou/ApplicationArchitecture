class Person...

    private final static String findStatementString =
        "SELECT id, lastname, firstname, number_of_dependents" +
        " FROM people" +
        " WHERE id = ?";
    public static Person find(Long id) {
        Person result = (Person) Registry.getPerson(id);
        if (result != null) return result;
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = DB.prepare(findStatementString);
            findStatement.setLong(1, id.longValue());
            rs = findStatement.executeQuery();
            rs.next();
            result = load(rs);
            return result;
        } catch (SQLException e) {
            throw new ApplicationException(e);
        } finally {
            DB.cleanUp(findStatement, rs);
        }
    }
    public static Person find(long id) {
        return find(new Long(id));
    }
    public static Person load(ResultSet rs) throws SQLException {
        Long id = new Long(rs.getLong(1));
        Person result = (Person) Registry.getPerson(id);
        if (result != null) return result;
        String lastNameArg = rs.getString(2);
        String firstNameArg = rs.getString(3);
        int numDependentsArg = rs.getInt(4);
        result = new Person(id, lastNameArg, firstNameArg, numDependentsArg);
        Registry.addPerson(result);
        return result;
    }