class Person...

    private final static String insertStatementString =
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
        } catch (Exception e) {
            throw new ApplicationException(e);
        } finally {
            DB.cleanUp(insertStatement);
        }
    }