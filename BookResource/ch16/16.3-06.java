class AbstractMapper...

    public void update(DomainObject object) {
        object.getVersion().increment();

class AbstractMapper...

    public void delete(DomainObject object) {
        object.getVersion().increment();