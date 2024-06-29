class FootballerMapper...

    protected override void AddRow (DomainObject obj) {
        base.AddRow(obj);
        InsertRow (obj, tableFor(TABLENAME));
    }

class AbstractPlayerMapper...

    protected override void AddRow (DomainObject obj) {
        InsertRow (obj, tableFor(TABLENAME));
    }

class Mapper...

    abstract protected void AddRow (DomainObject obj);
    protected virtual void InsertRow (DomainObject arg, DataTable table) {
        DataRow row = table.NewRow();
        row["id"] = arg.Id;
        table.Rows.Add(row);
    }