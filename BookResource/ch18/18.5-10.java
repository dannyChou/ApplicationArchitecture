class ThreadLocalRegistry...

    private PersonFinder personFinder = new PersonFinder();;
    public static PersonFinder personFinder() {
        return getInstance().personFinder;
    }