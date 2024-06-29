table version...

    create table version(id bigint primary key, value bigint,
        modifiedBy varchar, modified datetime)

class Version...

    private Long id;
    private long value;
    private String modifiedBy;
    private Timestamp modified;
    private boolean locked;
    private boolean isNew;
    private static final String UPDATE_SQL =
        "UPDATE version SET VALUE = ?, modifiedBy = ?, modified = ? " +
        "WHERE id = ? and value = ?";
    private static final String DELETE_SQL =
        "DELETE FROM version WHERE id = ? and value = ?";
    private static final String INSERT_SQL =
        "INSERT INTO version VALUES (?, ?, ?, ?)";
    private static final String LOAD_SQL =
        "SELECT id, value, modifiedBy, modified FROM version WHERE id = ?";
    public static Version find(Long id) {
        Version version = AppSessionManager.getSession().getIdentityMap().getVersion(id);
        if (version == null) {
            version = load(id);
        }
        return version;
    }
    private static Version load(Long id) {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        Version version = null;
        try {
            conn = ConnectionManager.INSTANCE.getConnection();
            pstmt = conn.prepareStatement(LOAD_SQL);
            pstmt.setLong(1, id.longValue());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                long value = rs.getLong(2);
                String modifiedBy = rs.getString(3);
                Timestamp modified = rs.getTimestamp(4);
                version = new Version(id, value, modifiedBy, modified);
                AppSessionManager.getSession().getIdentityMap().putVersion(version);
            } else {
                throw new ConcurrencyException("version " + id + " not found.");
            }
        } catch (SQLException sqlEx) {
            throw new SystemException("unexpected sql error loading version", sqlEx);
        } finally {
            cleanupDBResources(rs, conn, pstmt);
        }
        return version;
    }