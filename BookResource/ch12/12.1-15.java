class LineItemMapper...

    public LineItem find(long orderID, long seq) {
        Key key = new Key(new Long(orderID), new Long(seq));
        return (LineItem) abstractFind(key);
    }
    public LineItem find(Key key) {
        return (LineItem) abstractFind(key);
    }
    protected String findStatementString() {
        return
            "SELECT orderID, seq, amount, product " +
            " FROM line_items " +
            " WHERE (orderID = ?) AND (seq = ?)";
    }
    // 複合鍵覆寫的掛勾方法
    protected void loadFindStatement(Key key, PreparedStatement finder) throws SQLException {
        finder.setLong(1, orderID(key));
        finder.setLong(2, sequenceNumber(key));
    }
    // 輔助方法從訂單項目的鍵值中擷取適當的值
    private static long orderID(Key key) {
        return key.longValue(0);
    }
    private static long sequenceNumber(Key key) {
        return key.longValue(1);
    }