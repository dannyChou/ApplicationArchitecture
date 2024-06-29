class KeyGenerator...

    private void reserveIds() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        long newNextId;
        try {
            stmt = conn.prepareStatement("SELECT nextID FROM keys WHERE name = ? FOR UPDATE");
            stmt.setString(1, keyName);
            rs = stmt.executeQuery();
            rs.next();
            newNextId = rs.getLong(1);
        } catch (SQLException exc) {
            throw new ApplicationException("Unable to generate ids", exc);
        } finally {
            DB.cleanUp(stmt, rs);
        }
        long newMaxId = newNextId + incrementBy;
        stmt = null;
        try {
            stmt = conn.prepareStatement("UPDATE keys SET nextID = ? WHERE name = ?");
            stmt.setLong(1, newMaxId);
            stmt.setString(2, keyName);
            stmt.executeUpdate();
            conn.commit();
            nextId = newNextId;
            newMaxId = newMaxId;
        } catch (SQLException exc) {
            throw new ApplicationException("Unable to generate ids", exc);
        } finally {
            DB.cleanUp(stmt);
        }
    }