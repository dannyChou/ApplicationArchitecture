class AbstractPlayerMapper...

    abstract public String TypeCode {get;}
    protected static String TABLENAME = "Players";

class FootballerMapper...

    public override String TypeCode {
        get {return "F";}
    }
    protected new static String TABLENAME = "Footballers";