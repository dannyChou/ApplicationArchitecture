class AssociationTableLoader...

    private void addAllNewObjectsToIdentityMap() {
        for (Iterator it = inProgress.values().iterator();it.hasNext();)
            sourceMapper.putAsLoaded((DomainObject)it.next());
    }

class AbstractMapper...

    void putAsLoaded (DomainObject obj) {
        loadedMap.put (obj.getID(), obj);
    }
