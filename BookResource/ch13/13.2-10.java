class Criteria...

    public static Criteria matches(String fieldName, String pattern) {
        return new MatchCriteria(fieldName, pattern);
    }

class MatchCriteria extends Criteria...

    public String generateSql(DataMap dataMap) {
        return "UPPER(" + dataMap.getColumnForField(field) + ") LIKE UPPER('" + value + "')";
    }