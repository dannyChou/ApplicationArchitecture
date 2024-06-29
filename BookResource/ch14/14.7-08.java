class AssetApplicationController...

    public void addResponse(String event, Object state, Class domainCommand, String view) {
        Response newResponse = new Response (domainCommand, view);
        if (!events.containsKey(event))
            events.put(event, new HashMap());
        getResponseMap(event).put(state, newResponse);
    }
    private static void loadApplicationController(AssetApplicationController appController) {
        appController = AssetApplicationController.getDefault();
        appController.addResponse("return", AssetStatus.ON_LEASE,
                            GatherReturnDetailsCommand.class, "return");
        appController.addResponse("return", AssetStatus.IN_INVENTORY,
                            NullAssetCommand.class, "illegalAction");
        appController.addResponse("damage", AssetStatus.ON_LEASE,
                            InventoryDamageCommand.class, "leaseDamage");
        appController.addResponse("damage", AssetStatus.IN_INVENTORY,
                            LeaseDamageCommand.class, "inventoryDamage");
    }