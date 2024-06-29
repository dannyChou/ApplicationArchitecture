class ThreadLocalRegistry...

    public static void begin() {
        Assert.isTrue(instances.get() == null);
        instances.set(new ThreadLocalRegistry());
    }
    public static void end() {
        Assert.notNull(getInstance());
        instances.set(null);
    }