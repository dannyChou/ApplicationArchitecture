class PersonMapper...

    public Person find(Long key) {
        return (Person) findObject(key);
    }