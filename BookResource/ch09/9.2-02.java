class Contract...

    private List revenueRecognitions = new ArrayList();
    public Money recognizedRevenue(MfDate asOf) {
        Money result = Money.dollars(0);
        Iterator it = revenueRecognitions.iterator();
        while (it.hasNext()) {
            RevenueRecognition r = (RevenueRecognition) it.next();
            if (r.isRecognizableBy(asOf))
                result = result.add(r.getAmount());
        }
        return result;
    }