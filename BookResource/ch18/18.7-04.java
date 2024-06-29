class Money...

    public BigDecimal amount() {
        return BigDecimal.valueOf(amount, currency.getDefaultFractionDigits());
    }
    public Currency currency() {
        return currency;
    }