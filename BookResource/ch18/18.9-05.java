interface IdGenerator...

    public static final IdGenerator INSTANCE =
        (IdGenerator) PluginFactory.getPlugin(IdGenerator.class);