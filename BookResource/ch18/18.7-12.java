class Money...

    public Money multiply(double amount) {
        return multiply(new BigDecimal(amount));
    }
    public Money multiply(BigDecimal amount) {
        return multiply(amount, BigDecimal.ROUND_HALF_EVEN);
    }
    public Money multiply(BigDecimal amount, int roundingMode) {
        return new Money(amount().multiply(amount), currency, roundingMode);
    }