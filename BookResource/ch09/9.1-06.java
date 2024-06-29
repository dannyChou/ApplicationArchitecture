class Gateway...

    public void insertRecognition (long contractID, Money amount, MfDate asof) throws SQLException {
        PreparedStatement stmt = db.prepareStatement(insertRecognitionStatement);
        stmt.setLong(1, contractID);
        stmt.setBigDecimal(2, amount.amount());
        stmt.setDate(3, asof.toSqlDate());
        stmt.executeUpdate();
    }

    private static final String insertRecognitionStatement =
        "INSERT INTO revenueRecognitions VALUES (?, ?, ?)";