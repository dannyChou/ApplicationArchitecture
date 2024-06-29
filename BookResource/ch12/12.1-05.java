class KeyGenerator...

    private Connection conn;
    private String keyName;
    private long nextId;
    private long maxId;
    private int incrementBy;
    public KeyGenerator(Connection conn, String keyName, int incrementBy) {
        this.conn = conn;
        this.keyName = keyName;
        this.incrementBy = incrementBy;
        nextId = maxId = 0;
        try {
            conn.setAutoCommit(false);
        } catch(SQLException exc) {
            throw new ApplicationException("Unable to turn off autocommit", exc);
        }
    }