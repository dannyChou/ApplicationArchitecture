class CricketPage...

    protected virtual void applyDomainLogic (DataSet ds) {}

class BattingPage...

    override protected void applyDomainLogic (DataSet dataSet) {
        batting = new Batting(dataSet);
        batting.CalculateRates();
    }