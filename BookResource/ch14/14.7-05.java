class AssetApplicationController...

    public DomainCommand getDomainCommand (String commandString, Map params) {
        Response reponse = getResponse(commandString, getAssetStatus(params));
        return reponse.getDomainCommand();
    }
    private AssetStatus getAssetStatus(Map params) {
        String id = getParam("assetID", params);
        Asset asset = Asset.find(id);
        return asset.getStatus();
    }
    private String getParam(String key, Map params) {
        return ((String[]) params.get(key))[0];
    }