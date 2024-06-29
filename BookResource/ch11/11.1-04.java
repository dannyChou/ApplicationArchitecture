class UnitOfWork...

    private static ThreadLocal current = new ThreadLocal();
    public static void newCurrent() {
        setCurrent(new UnitOfWork());
    }
    public static void setCurrent(UnitOfWork uow) {
        current.set(uow);
    }
    public static UnitOfWork getCurrent() {
        return (UnitOfWork) current.get();
    }