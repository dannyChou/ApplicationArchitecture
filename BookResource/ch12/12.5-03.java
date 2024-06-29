class ProductOffering...

    public void update() {
        PreparedStatement stmt = null;
        try {
            stmt = DB.prepare(updateStatementString);
            stmt.setBigDecimal(1, baseCost.amount());
            stmt.setString(2, baseCost.currency().code());
            stmt.setInt(3, ID.intValue());
            stmt.execute();
        } catch (Exception e) {
            throw new ApplicationException(e);
        } finally {DB.cleanUp(stmt);}
    }
    private String updateStatementString =
        "UPDATE product_offerings" +
        " SET base_cost_amount = ?, base_cost_currency = ? " +
        " WHERE id = ?";