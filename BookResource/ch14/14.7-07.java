class AssetApplicationController...

    public String getView (String commandString, Map params) {
        return getResponse(commandString, getAssetStatus(params)).getViewUrl();
    }