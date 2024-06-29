class LineItemMapper...

    protected DomainObjectWithKey doLoad(Key key, ResultSet rs) throws SQLException {
        Order theOrder = MapperRegistry.order().find(orderID(key));
        return doLoad(key, rs, theOrder);
    }
    protected DomainObjectWithKey doLoad(Key key, ResultSet rs, Order order)
        throws SQLException
    {
        LineItem result;
        int amount = rs.getInt("amount");
        String product = rs.getString("product");
        result = new LineItem(key, amount, product);
        order.addLineItem(result);//訂單連結
        return result;
    }
    //覆寫預設情況
    protected Key createKey(ResultSet rs) throws SQLException {
        Key key = new Key(new Long(rs.getLong("orderID")), new Long(rs.getLong("seq")));
        return key;
    }