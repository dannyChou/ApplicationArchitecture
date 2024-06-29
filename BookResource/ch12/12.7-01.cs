class Mapper...

    protected DataTable table {
        get {return Gateway.Data.Tables[TableName];}
    }
    protected Gateway Gateway;
    abstract protected String TableName {get;}