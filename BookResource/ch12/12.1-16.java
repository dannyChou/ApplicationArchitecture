class AbstractMapper...

    protected DomainObjectWithKey load(ResultSet rs) throws SQLException {
        Key key = createKey(rs);
        if (loadedMap.containsKey(key)) return (DomainObjectWithKey) loadedMap.get(key);
        DomainObjectWithKey result = doLoad(key, rs);
        loadedMap.put(key, result);
        return result;
    }
    abstract protected DomainObjectWithKey doLoad(Key id, ResultSet rs) throws SQLException;
    // 用於非簡單整數鍵值的掛勾方法
    protected Key createKey(ResultSet rs) throws SQLException {
        return new Key(rs.getLong(1));
    }

class OrderMapper...

    protected DomainObjectWithKey doLoad(Key key, ResultSet rs) throws SQLException {
        String customer = rs.getString("customer");
        Order result = new Order(key, customer);
        MapperRegistry.lineItem().loadAllLineItemsFor(result);
        return result;
    }