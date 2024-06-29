class LineItemMapper...

    protected String insertStatementString() {
        return "INSERT INTO line_items VALUES (?, ?, ?, ?)";
    }
    protected void insertKey(DomainObjectWithKey subject, PreparedStatement stmt)
        throws SQLException
    {
        stmt.setLong(1, orderID(subject.getKey()));
        stmt.setLong(2, sequenceNumber(subject.getKey()));
    }