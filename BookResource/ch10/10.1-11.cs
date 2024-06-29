class DataSetHolder...

    public void Update() {
        foreach (String table in DataAdapters.Keys)
            ((OleDbDataAdapter)DataAdapters[table]).Update(Data, table);
    }
    public DataTable this[String tableName] {
        get {return Data.Tables[tableName];}
    }