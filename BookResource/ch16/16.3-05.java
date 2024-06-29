class Customer extends DomainObject...

    public static Customer create(String name) {
        return new Customer(IdGenerator.INSTANCE.nextId(), Version.create(),
            name, new ArrayList());
    }

class Customer extends DomainObject...

    public Address addAddress(String line1, String city, String state) {
        Address address = Address.create(this, getVersion(), line1, city, state);
        addresses.add(address);
        return address;
    }

class Address extends DomainObject...

    public static Address create(Customer customer, Version version,
        String line1, String city, String state) {
        return new Address(IdGenerator.INSTANCE.nextId(), version, customer,
                        line1, city, state);
    }

class AbstractMapper...

    public void insert(DomainObject object) {
        object.getVersion().insert();