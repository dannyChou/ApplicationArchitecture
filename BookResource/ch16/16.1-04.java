class CustomerMapper extends AbstractMapper...

    protected DomainObject load(Long id, ResultSet rs) throws SQLException {
        String name = rs.getString(2);
        return Customer.activate(id, name, addresses);
    }