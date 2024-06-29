class Mapper...

    public Gateway Gateway;
    private IDictionary identityMap = new Hashtable();
    public Mapper (Gateway gateway) {
        this.Gateway = gateway;
    }
    private DataTable table {
        get {return Gateway.Data.Tables[TableName];}
    }
    abstract public String TableName {get;}