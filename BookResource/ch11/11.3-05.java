class SupplierMapper...

    protected DomainObject doLoad(Long id, ResultSet rs) throws SQLException {
        String nameArg = rs.getString(2);
        SupplierVL result = new SupplierVL(id, nameArg);
        result.setProducts(new VirtualList(new ProductLoader(id)));
        return result;
    }