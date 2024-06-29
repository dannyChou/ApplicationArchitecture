class AbstractMapper...

    public Key insert(DomainObjectWithKey subject) {
        try {
            return performInsert(subject, findNextDatabaseKeyObject());
        } catch (SQLException e) {
            throw new ApplicationException(e);
        }
    }
    protected Key performInsert(DomainObjectWithKey subject, Key key) throws SQLException {
        subject.setKey(key);
        PreparedStatement stmt = DB.prepare(insertStatementString());
        insertKey(subject, stmt);
        insertData(subject, stmt);
        stmt.execute();
        loadedMap.put(subject.getKey(), subject);
        return subject.getKey();
    }
    abstract protected String insertStatementString();

class OrderMapper...

    protected String insertStatementString() {
        return "INSERT INTO orders VALUES(?,?)";
    }