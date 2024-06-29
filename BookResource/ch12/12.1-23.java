class LineItemMapper..

    protected void insertData(DomainObjectWithKey subject, PreparedStatement stmt)
        throws SQLException
    {
        LineItem item = (LineItem) subject;
        stmt.setInt(3, item.getAmount());
        stmt.setString(4, item.getProduct());
    }