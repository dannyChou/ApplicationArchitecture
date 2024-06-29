class PersonMapper...

    private static final String updateStatementString =
        "UPDATE people " +
        " SET lastname = ?, firstname = ?, number_of_dependents = ? " +
        " WHERE id = ?";
    public void update(Person subject) {
        PreparedStatement updateStatement = null;
        try {
            updateStatement = DB.prepare(updateStatementString);
            updateStatement.setString(1, subject.getLastName());
            updateStatement.setString(2, subject.getFirstName());
            updateStatement.setInt(3, subject.getNumberOfDependents());
            updateStatement.setInt(4, subject.getID().intValue());
            updateStatement.execute();
        } catch (Exception e) {
            throw new ApplicationException(e);
        } finally {
            DB.cleanUp(updateStatement);
        }
    }