class Mapper...

    public virtual void Update (DomainObject arg) {
        Save (arg, FindRow(arg.Id));
    }