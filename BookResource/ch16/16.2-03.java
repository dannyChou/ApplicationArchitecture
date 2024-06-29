class AppSession...

    private String user;
    private String id;
    private IdentityMap imap;
    public AppSession(String user, String id, IdentityMap imap) {
        this.user = user;
        this.imap = imap;
        this.id = id;
    }

class AppSessionManager...

    private static ThreadLocal current = new ThreadLocal();
    public static AppSession getSession() {
        return (AppSession) current.get();
    }
    public static void setSession(AppSession session) {
        current.set(session);
    }