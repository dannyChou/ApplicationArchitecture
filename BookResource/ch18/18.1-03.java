class Order...

    public void confirm() {
        if (isValid()) Environment.getMessageGateway().sendConfirmation(id, amount, symbol);
    }