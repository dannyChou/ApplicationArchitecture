class Album...

    public String Title;
    public Artist Artist;
    public IList Tracks {
        get {return ArrayList.ReadOnly(tracksData);}
    }
    public void AddTrack (Track arg) {
        tracksData.Add(arg);
    }
    public void RemoveTrack (Track arg) {
        tracksData.Remove(arg);
    }
    private IList tracksData = new ArrayList();

class Artist...

    public String Name;

class Track...

    public String Title;
    public IList Performers {
        get {return ArrayList.ReadOnly(performersData);}
    }
    public void AddPerformer (Artist arg) {
        performersData.Add(arg);
    }
    public void RemovePerformer (Artist arg) {
        performersData.Remove(arg);
    }
    private IList performersData = new ArrayList();