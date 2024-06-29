class Money...

    public static Money dollars(double amount) {
        return new Money(amount, Currency.USD);
    }