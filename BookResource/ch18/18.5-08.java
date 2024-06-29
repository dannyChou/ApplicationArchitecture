class ThreadLocalRegistry...

    private static ThreadLocal instances = new ThreadLocal();
    public static ThreadLocalRegistry getInstance() {
        return (ThreadLocalRegistry) instances.get();
    }