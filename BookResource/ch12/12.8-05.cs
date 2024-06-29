class PlayerMapper...

    public Player Find (long key) {
        DataRow row = FindRow(key, tableFor(TABLENAME));
        if (row == null) return null;
        else {
            String typecode = (String) row["type"];
            if (typecode == bmapper.TypeCode)
                return bmapper.Find(key);
            if (typecode == cmapper.TypeCode)
                return cmapper.Find(key);
            if (typecode == fmapper.TypeCode)
                return fmapper.Find(key);
            throw new Exception("unknown type");
        }
    }
    protected static String TABLENAME = "Players";