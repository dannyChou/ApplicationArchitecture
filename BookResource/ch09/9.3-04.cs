class Contract...

    public DataRow this[long key]
    {
        get
        {
            String filter = String.Format("ID = {0}", key);
            return table.Select(filter)[0];
        }
    }