class DataGateway...

    public long Insert(String lastName, String firstname, int numberOfDependents) {
        long key = new PersonGatewayDS().GetNextID();
        DataRow newRow = Table.NewRow();
        newRow["id"] = key;
        newRow["lastName"] = lastName;
        newRow["firstName"] = firstname;
        newRow["numberOfDependents"] = numberOfDependents;
        Table.Rows.Add(newRow);
        return key;
    }