class AbstractMapper...

    public void update(DomainObjectWithKey subject) {
        PreparedStatement stmt = null;
        try {
            stmt = DB.prepare(updateStatementString());
            loadUpdateStatement(subject, stmt);
            stmt.execute();
        } catch (SQLException e) {
            throw new ApplicationException(e);
        } finally {
            DB.cleanUp(stmt);
        }
    }
    abstract protected String updateStatementString();
    abstract protected void loadUpdateStatement(DomainObjectWithKey subject,
                            PreparedStatement stmt)
        throws SQLException;

class OrderMapper...

    protected void loadUpdateStatement(DomainObjectWithKey subject, PreparedStatement stmt) 
        throws SQLException
    {
        Order order = (Order) subject;
        stmt.setString(1, order.getCustomer());
        stmt.setLong(2, order.getKey().longValue());
    }
    protected String updateStatementString() {
        return "UPDATE orders SET customer = ? WHERE id = ?";
    }

class LineItemMapper...

    protected String updateStatementString() {
        return
            "UPDATE line_items " +
            " SET amount = ?, product = ? " +
            " WHERE orderId = ? AND seq = ?";
    }
    protected void loadUpdateStatement(DomainObjectWithKey subject, PreparedStatement stmt)
        throws SQLException
    {
        stmt.setLong(3, orderID(subject.getKey()));
        stmt.setLong(4, sequenceNumber(subject.getKey()));
        LineItem li = (LineItem) subject;
        stmt.setInt(1, li.getAmount());
        stmt.setString(2, li.getProduct());
    }