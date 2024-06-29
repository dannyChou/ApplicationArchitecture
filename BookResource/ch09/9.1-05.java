class Gateway...

    public ResultSet findContract (long contractID) throws SQLException{
        PreparedStatement stmt = db.prepareStatement(findContractStatement);
        stmt.setLong(1, contractID);
        ResultSet result = stmt.executeQuery();
        return result;
    }

    private static final String findContractStatement =
        "SELECT * " +
        " FROM contracts c, products p " +
        " WHERE ID = ? AND c.product = p.ID";