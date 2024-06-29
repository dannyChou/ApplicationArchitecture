class Mapper...

    public void update (DomainObject obj) {
        String sql = "UPDATE " + dataMap.getTableName() + dataMap.updateList() + " WHERE ID = ?";
        PreparedStatement stmt = null;
        try {
            stmt = DB.prepare(sql);
            int argCount = 1;
            for (Iterator it = dataMap.getColumns(); it.hasNext();) {
                ColumnMap col = (ColumnMap) it.next();
                stmt.setObject(argCount++, col.getValue(obj));
            }
            stmt.setLong(argCount, obj.getID().longValue());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ApplicationException (e);
        } finally {
            DB.cleanUp(stmt);
        }
    }

class DataMap...

    public String updateList() {
        StringBuffer result = new StringBuffer(" SET ");
        for (Iterator it = columnMaps.iterator(); it.hasNext();) {
            ColumnMap columnMap = (ColumnMap)it.next();
            result.append(columnMap.getColumnName());
            result.append("=?,");
        }
        result.setLength(result.length() - 1);
        return result.toString();
    }

    public Iterator getColumns() {
        return Collections.unmodifiableCollection(columnMaps).iterator();
    }

class ColumnMap...

    public Object getValue (Object subject) {
        try {
            return field.get(subject);
        } catch (Exception e) {
            throw new ApplicationException (e);
        }
    }