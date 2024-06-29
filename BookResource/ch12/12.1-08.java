class Key...

    private Object[] fields;
    public boolean equals(Object obj) {
        if (!(obj instanceof Key)) return false;
        Key otherKey = (Key) obj;
        if (this.fields.length != otherKey.fields.length) return false;
        for (int i = 0; i < fields.length; i++)
            if (!this.fields[i].equals(otherKey.fields[i])) return false;
        return true;
    }