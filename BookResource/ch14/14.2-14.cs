class CricketPage...

    abstract protected String[] mandatoryParameters();
    private Boolean hasMissingParameters() {
        foreach (String param in mandatoryParameters())
            if (Request.Params[param] == null) return true;
        return false;
    }
    private String missingParameterMessage {
        get {
            String result = "<P>This page is missing mandatory parameters:</P>";
            result += "<UL>";
            foreach (String param in mandatoryParameters())
                if (Request.Params[param] == null)
                    result += String.Format("<LI>{0}</LI>", param);
                result += "</UL>";
                return result;
        }
    }
    protected void errorTransfer (String message) {
        Context.Items.Add("errorMessage", message);
        Context.Server.Transfer("Error.aspx");
    }

class BattingPage...

    override protected String[] mandatoryParameters() {
        String[] result = {"team", "innings", "match"};
        return result;
    }