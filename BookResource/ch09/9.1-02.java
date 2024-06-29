class Gateway...

    public ResultSet findRecognitionsFor(long contractID, MfDate asof) throws SQLException {
        PreparedStatement stmt = db.prepareStatement(findRecognitionsStatement);
        stmt.setLong(1, contractID);
        stmt.setDate(2, asof.toSqlDate());
        ResultSet result = stmt.executeQuery();
        return result;
    }

    private static final String findRecognitionsStatement =
        "SELECT amount " +
        " FROM revenueRecognitions " +
        " WHERE contract = ? AND recognizedOn <= ?";
    private Connection db;