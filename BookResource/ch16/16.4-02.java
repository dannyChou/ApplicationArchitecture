LockingMapperRegistry implements MappingRegistry...

    private Map mappers = new HashMap();
    public void registerMapper(Class cls, Mapper mapper) {
        mappers.put(cls, new LockingMapper(mapper));
    }
    public Mapper getMapper(Class cls) {
        return (Mapper) mappers.get(cls);
    }