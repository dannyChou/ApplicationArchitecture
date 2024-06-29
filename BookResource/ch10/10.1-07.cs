class DataGateway...

    protected DataGateway() {
        Holder = new DataSetHolder();
    }
    protected DataGateway(DataSetHolder holder) {
        this.Holder = holder;
    }