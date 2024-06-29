class PersonFinder...

    private final static String findStatementString =
        "SELECT id, lastname, firstname, number_of_dependents " +
        " from people " +
        " WHERE id = ?";
    public PersonGateway find(Long id) {
        PersonGateway result = (PersonGateway) Registry.getPerson(id);
        if (result != null) return result;
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = DB.prepare(findStatementString);
            findStatement.setLong(1, id.longValue());
            rs = findStatement.executeQuery();
            rs.next();
            result = PersonGateway.load(rs);
            return result;
        } catch (SQLException e) {
            throw new ApplicationException(e);
        } finally {
            DB.cleanUp(findStatement, rs);
        }
    }
    public PersonGateway find(long id) {
        return find(new Long(id));
    }

class PersonGateway...

    public static PersonGateway load(ResultSet rs) throws SQLException {
        Long id = new Long(rs.getLong(1));
        PersonGateway result = (PersonGateway) Registry.getPerson(id);
        if (result != null) return result;
        String lastNameArg = rs.getString(2);
        String firstNameArg = rs.getString(3);
        int numDependentsArg = rs.getInt(4);
        result = new PersonGateway(id, lastNameArg, firstNameArg, numDependentsArg);
        Registry.addPerson(result);
        return result;
    }