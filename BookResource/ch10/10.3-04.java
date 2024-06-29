class Person...

    private final static String updateStatementString =
        "UPDATE people" +
        " set lastname = ?, firstname = ?, number_of_dependents = ?" +
        " where id = ?";
    public void update() {
        PreparedStatement updateStatement = null;
        try {
            updateStatement = DB.prepare(updateStatementString);
            updateStatement.setString(1, lastName);
            updateStatement.setString(2, firstName);
            updateStatement.setInt(3, numberOfDependents);
            updateStatement.setInt(4, getID().intValue());
            updateStatement.execute();
        } catch (Exception e) {
            throw new ApplicationException(e);
        } finally {
            DB.cleanUp(updateStatement);
        }
    }