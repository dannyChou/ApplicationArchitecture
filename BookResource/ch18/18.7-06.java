class Money...

    public boolean equals(Object other) {
        return (other instanceof Money) && equals((Money)other);
    }
    public boolean equals(Money other) {
        return currency.equals(other.currency) && (amount == other.amount);
    }