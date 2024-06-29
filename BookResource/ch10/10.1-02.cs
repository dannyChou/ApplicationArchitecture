class PersonGateway...

    public Object[] FindRow (long key) {
        String sql = "SELECT * FROM person WHERE id = ?";
        IDbCommand comm = new OleDbCommand(sql, DB.Connection);
        comm.Parameters.Add(new OleDbParameter("key",key));
        IDataReader reader = comm.ExecuteReader();
        reader.Read();
        Object [] result = new Object[reader.FieldCount];
        reader.GetValues(result);
        reader.Close();
        return result;
    }