class PlayerMapper...

    public Player Find (long key) {
        DataRow row = FindRow(key);
        if (row == null) return null;
        else {
            String typecode = (String) row["type"];
            switch (typecode){
                case BowlerMapper.TYPE_CODE:
                    return (Player) bmapper.Find(row);
                case CricketerMapper.TYPE_CODE:
                    return (Player) cmapper.Find(row);
                case FootballerMapper.TYPE_CODE:
                    return (Player) fmapper.Find(row);
                default:
                    throw new Exception("unknown type");
            }
        }
    }