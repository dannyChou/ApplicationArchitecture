class Mapper...

    public DomainObject load(ResultSet rs)
        throwsInstantiationException, IllegalAccessException, SQLException
    {
        Long key = new Long(rs.getLong("ID"));
        if (uow.isLoaded(key)) return uow.getObject(key);
        DomainObject result = (DomainObject) dataMap.getDomainClass().newInstance();
        result.setID(key);
        uow.registerClean(result);
        loadFields(rs, result);
        return result;
    }

    private void loadFields(ResultSet rs, DomainObject result) throws SQLException {
        for (Iterator it = dataMap.getColumns(); it.hasNext();) {
            ColumnMap columnMap = (ColumnMap)it.next();
            Object columnValue = rs.getObject(columnMap.getColumnName());
            columnMap.setField(result, columnValue);
        }
    }

class ColumnMap...

    public void setField(Object result, Object columnValue) {
        try {
            field.set(result, columnValue);
        } catch (Exception e) {
            throw new ApplicationException ("Error in setting " + fieldName, e);
        }
    }