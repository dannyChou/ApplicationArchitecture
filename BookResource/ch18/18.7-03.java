    public Money(double amount, Currency currency) {
        this.currency = currency;
        this.amount = Math.round(amount * centFactor());
    }
    public Money(long amount, Currency currency) {
        this.currency = currency;
        this.amount = amount * centFactor();
    }
    private static final int[] cents = new int[] { 1, 10, 100, 1000 };
    private int centFactor() {
        return cents[currency.getDefaultFractionDigits()];
    }