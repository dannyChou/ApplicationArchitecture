class Money...

    public Money add(Money other) {
        assertSameCurrencyAs(other);
        return newMoney(amount + other.amount);
    }
    private void assertSameCurrencyAs(Money arg) {
        Assert.equals("money math mismatch", currency, arg.currency);
    }
    private Money newMoney(long amount) {
        Money money = new Money();
        money.currency = this.currency;
        money.amount = amount;
        return money;
    }