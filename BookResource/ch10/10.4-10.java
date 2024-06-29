class AbstractMapper...

    public Long insert(DomainObject subject) {
        PreparedStatement insertStatement = null;
        try {
            insertStatement = DB.prepare(insertStatement());
            subject.setID(findNextDatabaseId());
            insertStatement.setInt(1, subject.getID().intValue());
            doInsert(subject, insertStatement);
            insertStatement.execute();
            loadedMap.put(subject.getID(), subject);
            return subject.getID();
        } catch (SQLException e) {
            throw new ApplicationException(e);
        } finally {
            DB.cleanUp(insertStatement);
        }
    }
    abstract protected String insertStatement();
    abstract protected void doInsert(DomainObject subject, PreparedStatement insertStatement)
        throws SQLException;

class PersonMapper...

    protected String insertStatement() {
        return "INSERT INTO people VALUES (?, ?, ?, ?)";
    }
    protected void doInsert(
        DomainObject abstractSubject,
        PreparedStatement stmt)
        throws SQLException
    {
        Person subject = (Person) abstractSubject;
        stmt.setString(2, subject.getLastName());
        stmt.setString(3, subject.getFirstName());
        stmt.setInt(4, subject.getNumberOfDependents());
    }