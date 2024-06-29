class UnitOfWork...

    public void registerNew(DomainObject obj) {
        Assert.notNull("id not null", obj.getId());
        Assert.isTrue("object not dirty", !dirtyObjects.contains(obj));
        Assert.isTrue("object not removed", !removedObjects.contains(obj));
        Assert.isTrue("object not already registered new", !newObjects.contains(obj));
        newObjects.add(obj);
    }
    public void registerDirty(DomainObject obj) {
        Assert.notNull("id not null", obj.getId());
        Assert.isTrue("object not removed", !removedObjects.contains(obj));
        if (!dirtyObjects.contains(obj) && !newObjects.contains(obj)) {
            dirtyObjects.add(obj);
        }
    }
    public void registerRemoved(DomainObject obj) {
        Assert.notNull("id not null", obj.getId());
        if (newObjects.remove(obj)) return;
        dirtyObjects.remove(obj);
        if (!removedObjects.contains(obj)) {
            removedObjects.add(obj);
        }
    }
    public void registerClean(DomainObject obj) {
        Assert.notNull("id not null", obj.getId());
    }