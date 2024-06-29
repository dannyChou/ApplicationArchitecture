class TeamMapper...

    public Team Find(long id) {
        return (Team) AbstractFind(id);
    }