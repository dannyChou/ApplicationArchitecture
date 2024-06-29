class Mapper...

    public Long insert (DomainObject obj) {
        String sql = "INSERT INTO " + dataMap.getTableName() +
                     " VALUES (?" + dataMap.insertList() + ")";
        PreparedStatement stmt = null;
        try {
            stmt = DB.prepare(sql);
            stmt.setObject(1, obj.getID());
            int argCount = 2;
            for (Iterator it = dataMap.getColumns(); it.hasNext();) {
                ColumnMap col = (ColumnMap) it.next();
                stmt.setObject(argCount++, col.getValue(obj));
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ApplicationException (e);
        } finally {
            DB.cleanUp(stmt);
        }
        return obj.getID();
    }

class DataMap...

    public String insertList() {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < columnMaps.size(); i++) {
            result.append(",");
            result.append("?");
        }
        return result.toString();
    }