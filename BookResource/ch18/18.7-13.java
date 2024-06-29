class Money...

    public Money[] allocate(int n) {
        Money lowResult = newMoney(amount / n);
        Money highResult = newMoney(lowResult.amount + 1);
        Money[] results = new Money[n];
        int remainder = (int) amount % n;
        for (int i = 0; i < remainder; i++) results[i] = highResult;
        for (int i = remainder; i < n; i++) results[i] = lowResult;
        return results;
    }