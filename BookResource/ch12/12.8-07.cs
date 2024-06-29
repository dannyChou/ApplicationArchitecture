class FootballerMapper...

    protected override void Save(DomainObject obj) {
        base.Save(obj);
        DataRow row = FindRow (obj.Id, tableFor(TABLENAME));
        Footballer footballer = (Footballer) obj;
        row["club"] = footballer.club;
    }

class AbstractPlayerMapper...

    protected override void Save(DomainObject obj) {
        DataRow row = FindRow (obj.Id, tableFor(TABLENAME));
        Player player = (Player) obj;
        row["name"] = player.name;
        row["type"] = TypeCode;
    }