class Money...

    public void testAllocate2() {
        long[] allocation = {3,7};
        Money[] result = Money.dollars(0.05).allocate(allocation);
        assertEquals(Money.dollars(0.02), result[0]);
        assertEquals(Money.dollars(0.03), result[1]);
    }