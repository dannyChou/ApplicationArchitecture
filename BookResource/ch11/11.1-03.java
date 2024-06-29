class UnitOfWork...

    public void commit() {
        insertNew();
        updateDirty();
        deleteRemoved();
    }
    private void insertNew() {
        for (Iterator objects = newObjects.iterator(); objects.hasNext();) {
            DomainObject obj = (DomainObject) objects.next();
            MapperRegistry.getMapper(obj.getClass()).insert(obj);
        }
    }