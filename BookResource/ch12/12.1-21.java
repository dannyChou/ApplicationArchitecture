class AbstractMapper...

    abstract protected void insertData(DomainObjectWithKey subject, PreparedStatement stmt)
        throws SQLException;

class OrderMapper...

    protected void insertData(DomainObjectWithKey abstractSubject, PreparedStatement stmt) {
        try {
            Order subject = (Order) abstractSubject;
            stmt.setString(2, subject.getCustomer());
        } catch (SQLException e) {
            throw new ApplicationException(e);
        }
    }