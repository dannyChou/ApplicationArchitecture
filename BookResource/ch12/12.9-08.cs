class PlayerMapper...

    public Player Find (long key) {
        Player result;
        result = fmapper.Find(key);
        if (result != null) return result;
        result = bmapper.Find(key);
        if (result != null) return result;
        result = cmapper.Find(key);
        if (result != null) return result;
        return null;
    }