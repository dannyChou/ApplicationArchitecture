class PersonGateway...

    private static final String updateStatementString =
        "UPDATE people " +
        " set lastname = ?, firstname = ?, number_of_dependents = ? " +
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
    private static final String insertStatementString =
        "INSERT INTO people VALUES (?, ?, ?, ?)";
    public Long insert() {
        PreparedStatement insertStatement = null;
        try {
            insertStatement = DB.prepare(insertStatementString);
            setID(findNextDatabaseId());
            insertStatement.setInt(1, getID().intValue());
            insertStatement.setString(2, lastName);
            insertStatement.setString(3, firstName);
            insertStatement.setInt(4, numberOfDependents);
            insertStatement.execute();
            Registry.addPerson(this);
            return getID();
        } catch (SQLException e) {
            throw new ApplicationException(e);
        } finally {
            DB.cleanUp(insertStatement);
        }
    }