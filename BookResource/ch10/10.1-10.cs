class DataGateway...

    public DataRow this[long key] {
        get {
            String filter = String.Format("id = {0}", key);
            return Table.Select(filter)[0];
        }
    }
    public override DataTable Table {
        get { return Data.Tables[TableName];}
    }