class ColumnMap...

    public ColumnMap(String columnName, String fieldName, DataMap dataMap) {
        this.columnName = columnName;
        this.fieldName = fieldName;
        this.dataMap = dataMap;
        initField();
    }
    private void initField() {
        try {
            field = dataMap.getDomainClass().getDeclaredField(getFieldName());
            field.setAccessible(true);
        } catch (Exception e) {
            throw new ApplicationException ("unable to set up field: " + fieldName, e);
        }
    }