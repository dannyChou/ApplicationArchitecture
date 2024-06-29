class QueryObject...

    private String generateWhereClause() {
        StringBuffer result = new StringBuffer();
        for (Iterator it = criteria.iterator(); it.hasNext();) {
            Criteria c = (Criteria)it.next();
            if (result.length() != 0)
                result.append(" AND ");
            result.append(c.generateSql(uow.getMapper(klass).getDataMap()));
        }
        return result.toString();
    }

class Criteria...

    public String generateSql(DataMap dataMap) {
        return dataMap.getColumnForField(field) + sqlOperator + value;
    }

class DataMap...

    public String getColumnForField (String fieldName) {
        for (Iterator it = getColumns(); it.hasNext();) {
            ColumnMap columnMap = (ColumnMap)it.next();
            if (columnMap.getFieldName().equals(fieldName))
                return columnMap.getColumnName();
        }
        throw new ApplicationException ("Unable to find column for " + fieldName);
    }