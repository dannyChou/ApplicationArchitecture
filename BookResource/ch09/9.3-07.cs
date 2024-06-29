class RevenueRecognition...

    public long Insert(long contractID, Decimal amount, DateTime date) {
        DataRow newRow = table.NewRow();
        long id = GetNextID();
        newRow["ID"] = id;
        newRow["contractID"] = contractID;
        newRow["amount"] = amount;
        newRow["date"] = String.Format("{0:s}", date);
        table.Rows.Add(newRow); return id;
    }