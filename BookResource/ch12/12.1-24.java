class LineItemMapper...

    public Key insert(DomainObjectWithKey subject) {
        throw new UnsupportedOperationException
            ("Must supply an order when inserting a line item");
    }
    public Key insert(LineItem item, Order order) {
        try {
            Key key = new Key(order.getKey().value(), getNextSequenceNumber(order));
            return performInsert(item, key);
        } catch (SQLException e) {
            throw new ApplicationException(e);
        }
    }