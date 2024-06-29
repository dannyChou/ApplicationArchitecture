class AbstractMapper...

    public virtual void Update (DomainObject arg) {
        Save (arg, FindRow(arg.Id));
    }
    abstract protected void Save (DomainObject arg, DataRow row);

class TeamMapper...

    protected override void Save (DomainObject obj, DataRow row){
        Team team = (Team) obj;
        row["name"] = team.Name;
        savePlayers(team);
    }
    private void savePlayers(Team team){
        foreach (Player p in team.Players) {
            MapperRegistry.Player.LinkTeam(p, team.Id);
        }
    }

class PlayerMapper...

    public void LinkTeam (Player player, long teamID) {
        DataRow row = FindRow(player.Id);
        row["teamID"] = teamID;
    }