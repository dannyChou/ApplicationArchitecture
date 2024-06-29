class Employee...

    public String Name {
        get {
            Load();
            return _name;
        }
        set {
            Load();
            _name = value;
        }
    }
    String _name;

class Domain Object...

    protected void Load() {
        if (IsGhost)
            DataSource.Load(this);
    }