class Key...

    public Key(Object[] fields) {
        checkKeyNotNull(fields);
        this.fields = fields;
    }
    private void checkKeyNotNull(Object[] fields) {
        if (fields == null) throw new IllegalArgumentException("Cannot have a null key");
        for (int i = 0; i < fields.length; i++)
            if (fields[i] == null)
                throw new IllegalArgumentException("Cannot have a null element of key");
    }