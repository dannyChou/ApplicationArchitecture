class RevenueRecognition...

    public Decimal RecognizedRevenue(long contractID, DateTime asOf)
    {
        String filter = String.Format("ContractID = {0} AND date <= #{1:d}#", contractID, asOf);
        DataRow[] rows = table.Select(filter);
        Decimal result = 0m;
        foreach (DataRow row in rows)
        {
            result += (Decimal)row["amount"];
        }
        return result;
    }