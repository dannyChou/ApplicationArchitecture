class LineItemMapper...

    public void loadAllLineItemsFor(Order arg) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = DB.prepare(findForOrderString);
            stmt.setLong(1, arg.getKey().longValue());
            rs = stmt.executeQuery();
            while (rs.next())
                load(rs, arg);
        } catch (SQLException e) {
            throw new ApplicationException(e);
        } finally {
            DB.cleanUp(stmt, rs);
        }
    }
    private final static String findForOrderString =
        "SELECT orderID, seq, amount, product " +
        "FROM line_items " +
        "WHERE orderID = ?";
    protected DomainObjectWithKey load(ResultSet rs, Order order) throws SQLException {
        Key key = createKey(rs);
        if (loadedMap.containsKey(key)) return (DomainObjectWithKey) loadedMap.get(key);
        DomainObjectWithKey result = doLoad(key, rs, order);
        loadedMap.put(key, result);
        return result;
    }