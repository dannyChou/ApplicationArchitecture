class AssociationTableLoader...

    private List formResult() {
        List result = new ArrayList();
        for (Iterator it = resultIds.iterator(); it.hasNext();) {
            Long id = (Long)it.next();
            result.add(sourceMapper.lookUp(id));
        }
        return result;
    }

class AbstractMapper...

    protected DomainObject lookUp (Long id) {
        return (DomainObject) loadedMap.get(id);
    }