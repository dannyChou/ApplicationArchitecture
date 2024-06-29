class CricketerMapper...

    protected override void Save(DomainObject obj, DataRow row) {
        base.Save(obj, row);
        Cricketer cricketer = (Cricketer) obj;
        row["battingAverage"] = cricketer.battingAverage;
    }

class AbstractPlayerMapper...

    protected override void Save(DomainObject obj, DataRow row) {
        Player player = (Player) obj;
        row["name"] = player.name;
    }