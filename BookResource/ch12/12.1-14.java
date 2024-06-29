class OrderMapper...

    public Order find(Key key) {
        return (Order) abstractFind(key);
    }
    public Order find(Long id) {
        return find(new Key(id));
    }
    protected String findStatementString() {
        return "SELECT id, customer from orders WHERE id = ?";
    }

class AbstractMapper...

    abstract protected String findStatementString();
    protected Map loadedMap = new HashMap();
    public DomainObjectWithKey abstractFind(Key key) {
        DomainObjectWithKey result = (DomainObjectWithKey) loadedMap.get(key);
        if (result != null) return result;
        ResultSet rs = null;
        PreparedStatement findStatement = null;
        try {
            findStatement = DB.prepare(findStatementString());
            loadFindStatement(key, findStatement);
            rs = findStatement.executeQuery();
            rs.next();
            if (rs.isAfterLast()) return null;
            result = load(rs);
            return result;
        } catch (SQLException e) {
            throw new ApplicationException(e);
        } finally {
            DB.cleanUp(findStatement, rs);
        }
    }
    // 用於非簡單整數鍵值的掛勾方法
    protected void loadFindStatement(Key key, PreparedStatement finder) throws SQLException {
        finder.setLong(1, key.longValue());
    }