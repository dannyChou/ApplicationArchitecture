class Mapper...

    public virtual long Insert (DomainObject obj) {
        obj.Id = GetNextID();
        AddRow(obj);
        Save(obj);
        return obj.Id;
    }