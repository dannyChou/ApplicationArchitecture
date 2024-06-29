class Key...

    public Object value(int i) {
        return fields[i];
    }
    public Object value() {
        checkSingleKey();
        return fields[0];
    }
    private void checkSingleKey() {
        if (fields.length > 1)
            throw new IllegalStateException("Cannot take value on composite key");
    }
    public long longValue() {
        checkSingleKey();
        return longValue(0);
    }
    public long longValue(int i) {
        if (!(fields[i] instanceof Long))
            throw new IllegalStateException("Cannot take longValue on non long key");
        return ((Long)) fields[i]).longValue();
    }