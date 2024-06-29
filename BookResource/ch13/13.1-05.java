class Mapper...

    public Object findObject (Long key) {
        if (uow.isLoaded(key)) return uow.getObject(key);
        String sql = "SELECT" + dataMap.columnList() + " FROM " + dataMap.getTableName() + " WHERE
            ID = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        DomainObject result = null;
        try {
            stmt = DB.prepare(sql);
            stmt.setLong(1, key.longValue());
            rs = stmt.executeQuery();
            rs.next();
            result = load(rs);
        } catch (Exception e) {
            throw new ApplicationException (e);
        } finally {
            DB.cleanUp(stmt, rs);
        }
        return result;
    }
    private UnitOfWork uow;
    protected DataMap dataMap;

class DataMap...

    public String columnList() {
        StringBuffer result = new StringBuffer(" ID");
        for (Iterator it = columnMaps.iterator(); it.hasNext();) {
            result.append(",");
            ColumnMap columnMap = (ColumnMap)it.next();
            result.append(columnMap.getColumnName());
        }
        return result.toString();
    }
    public String getTableName() {
        return tableName;
    }