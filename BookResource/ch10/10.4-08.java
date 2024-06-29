class PersonMapper...

    public List findByLastName2(String pattern) {
        return findMany(new FindByLastName(pattern));
    }
    static class FindByLastName implements StatementSource {
        private String lastName;
        public FindByLastName(String lastName) {
            this.lastName = lastName;
        }
        public String sql() {
            return
                "SELECT " + COLUMNS +
                " FROM people " +
                " WHERE UPPER(lastname) like UPPER(?)" +
                " ORDER BY lastname";
        }
        public Object[] parameters() {
            Object[] result = {lastName};
            return result;
        }
    }