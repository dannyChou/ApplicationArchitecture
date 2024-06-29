class ProductOffering...

    public static ProductOffering load(ResultSet rs) {
        try {
            Integer id = (Integer) rs.getObject("ID");
            BigDecimal baseCostAmount = rs.getBigDecimal("base_cost_amount");
            Currency baseCostCurrency = Registry.getCurrency(rs.getString("base_cost_currency"));
            Money baseCost = new Money(baseCostAmount, baseCostCurrency);
            Integer productID = (Integer) rs.getObject("product");
            Product product = Product.find((Integer) rs.getObject("product"));
            return new ProductOffering(id, product, baseCost);
        } catch (SQLException e) {
            throw new ApplicationException(e);
        }
    }