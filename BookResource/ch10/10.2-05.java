class PersonFinder...

    private static final String findResponsibleStatement =
        "SELECT id, lastname, firstname, number_of_dependents " +
        " from people " +
        " WHERE number_of_dependents > 0";
    public List findResponsibles() {
        List result = new ArrayList();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = DB.prepare(findResponsibleStatement);
            rs = stmt.executeQuery();
            while (rs.next()) {
                result.add(PersonGateway.load(rs));
            }
            return result;
        } catch (SQLException e) {
            throw new ApplicationException(e);
        } finally {
            DB.cleanUp(stmt, rs);
        }
    }