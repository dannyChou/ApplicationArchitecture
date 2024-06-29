class AbstractMapper...

    public void delete(DomainObjectWithKey subject) {
        PreparedStatement stmt = null;
        try {
            stmt = DB.prepare(deleteStatementString());
            loadDeleteStatement(subject, stmt);
            stmt.execute();
        } catch (SQLException e) {
            throw new ApplicationException(e);
        } finally {
            DB.cleanUp(stmt);
        }
    }
    abstract protected String deleteStatementString();
    protected void loadDeleteStatement(DomainObjectWithKey subject, PreparedStatement stmt)
        throws SQLException
    {
        stmt.setLong(1, subject.getKey().longValue());
    }

class OrderMapper...

    protected String deleteStatementString() {
        return "DELETE FROM orders WHERE id = ?";
    }

class LineItemMapper...

    protected String deleteStatementString() {
        return "DELETE FROM line_items WHERE orderid = ? AND seq = ?";
    }
    protected void loadDeleteStatement(DomainObjectWithKey subject, PreparedStatement stmt)
        throws SQLException
    {
        stmt.setLong(1, orderID(subject.getKey()));
        stmt.setLong(2, sequenceNumber(subject.getKey()));
    }