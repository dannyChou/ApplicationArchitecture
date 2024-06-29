class AbstractMapper...

    protected void insertKey(DomainObjectWithKey subject, PreparedStatement stmt)
        throws SQLException
    {
        stmt.setLong(1, subject.getKey().longValue());
    }