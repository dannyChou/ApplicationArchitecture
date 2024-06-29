class Criteria...

    public static Criteria greaterThan(String fieldName, int value) {
        return Criteria.greaterThan(fieldName, new Integer(value));
    }
    public static Criteria greaterThan(String fieldName, Object value) {
        return new Criteria(" > ", fieldName, value);
    }
    private Criteria(String sql, String field, Object value) {
        this.sqlOperator = sql;
        this.field = field;
        this.value = value;
    }