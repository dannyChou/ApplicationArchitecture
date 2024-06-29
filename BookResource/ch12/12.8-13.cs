class PlayerMapper...

    override public void Delete(DomainObject obj) {
        MapperFor(obj).Delete(obj);
    }