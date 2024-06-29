class PersonMapper...

    private static String findLastNameStatement =
        "SELECT " + COLUMNS +
        " FROM people " +
        " WHERE UPPER(lastname) like UPPER(?)" +
        " ORDER BY lastname";
    public List findByLastName(String name) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = DB.prepare(findLastNameStatement);
            stmt.setString(1, name);
            rs = stmt.executeQuery();
            return loadAll(rs);
        } catch (SQLException e) {
            throw new ApplicationException(e);
        } finally {
            DB.cleanUp(stmt, rs);
        }
    }

class AbstractMapper...

    protected List loadAll(ResultSet rs) throws SQLException {
        List result = new ArrayList();
        while (rs.next())
            result.add(load(rs));
        return result;
    }