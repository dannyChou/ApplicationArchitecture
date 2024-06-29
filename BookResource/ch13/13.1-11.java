class PersonMapper...

    public Set findLastNamesLike (String pattern) {
        String sql =
            "SELECT" + dataMap.columnList() +
            " FROM " + dataMap.getTableName() +
            " WHERE UPPER(lastName) like UPPER(?)";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = DB.prepare(sql);
            stmt.setString(1, pattern);
            rs = stmt.executeQuery();
            return loadAll(rs);
        } catch (Exception e) {
            throw new ApplicationException (e);
        } finally {
            DB.cleanUp(stmt, rs);
        }
    }