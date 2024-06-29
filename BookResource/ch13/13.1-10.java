class Mapper...

    public Set findObjectsWhere (String whereClause) {
        String sql = "SELECT" + dataMap.columnList() + " FROM " + dataMap.getTableName() + 
            " WHERE " + whereClause;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Set result = new HashSet();
        try {
            stmt = DB.prepare(sql);
            rs = stmt.executeQuery();
            result = loadAll(rs);
        } catch (Exception e) {
            throw new ApplicationException (e);
        } finally {
            DB.cleanUp(stmt, rs);
        }
        return result;
    }

    public Set loadAll(ResultSet rs) throws SQLException, InstantiationException,
        IllegalAccessException {
        Set result = new HashSet();
        while (rs.next()) {
            DomainObject newObj = (DomainObject) dataMap.getDomainClass().newInstance();
            newObj = load (rs);
            result.add(newObj);
        }
        return result;
    }