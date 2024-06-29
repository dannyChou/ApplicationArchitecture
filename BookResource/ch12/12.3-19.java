class AssociationTableLoader...

    private List resultIds = new ArrayList();
    private Map inProgress = new HashMap();
    private void loadRow() throws SQLException {
        Long ID = new Long(rs.getLong(1));
        if (!resultIds.contains(ID)) resultIds.add(ID);
        if (!sourceMapper.hasLoaded(ID)) {
            if (!inProgress.keySet().contains(ID))
                inProgress.put(ID, sourceMapper.loadRow(ID, rs));
            targetAdder.add((DomainObject) inProgress.get(ID), rs);
        }
    }

class AbstractMapper...

    boolean hasLoaded(Long id) {
        return loadedMap.containsKey(id);
    }
