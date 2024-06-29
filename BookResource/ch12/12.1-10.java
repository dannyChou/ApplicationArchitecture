class Key...

    public Key(long arg) {
        this.fields = new Object[1];
        this.fields[0] = new Long(arg);
    }
    public Key(Object field) {
        if (field == null) throw new IllegalArgumentException("Cannot have a null key");
        this.fields = new Object[1];
        this.fields[0] = field;
    }
    public Key(Object arg1, Object arg2) {
        this.fields = new Object[2];
        this.fields[0] = arg1;
        this.fields[1] = arg2;
        checkKeyNotNull(fields);
    }