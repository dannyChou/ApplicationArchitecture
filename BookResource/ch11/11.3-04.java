class SupplierMapper...

    public static class ProductLoader implements VirtualListLoader {
        private Long id;
        public ProductLoader(Long id) {
            this.id = id;
        }
        public List load() {
            return ProductMapper.create().findForSupplier(id);
        }
    }