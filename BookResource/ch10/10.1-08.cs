class DataGateway...

    public void LoadAll() {
        String commandString = String.Format("select * from {0}", TableName);
        Holder.FillData(commandString, TableName);
    }
    public void LoadWhere(String whereClause) {
        String commandString =
        String.Format("select * from {0} where {1}", TableName,whereClause);
        Holder.FillData(commandString, TableName);
    }
    abstract public String TableName {get;}

class PersonGateway...

    public override String TableName {
        get {return "Person";}
    }

class DataSetHolder...

    public void FillData(String query, String tableName) {
        if (DataAdapters.Contains(tableName)) throw new MutlipleLoadException();
        OleDbDataAdapter da = new OleDbDataAdapter(query, DB.Connection);
        OleDbCommandBuilder builder = new OleDbCommandBuilder(da);
        da.Fill(Data, tableName);
        DataAdapters.Add(tableName, da);
    }