class FootballerMapper...

    public Footballer Find(long id) {
        return (Footballer) AbstractFind (id, TABLENAME);
    }