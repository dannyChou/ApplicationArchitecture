class Contract...

    public void calculateRecognitions() {
        product.calculateRevenueRecognitions(this);
    }

class Product...

    void calculateRevenueRecognitions(Contract contract) {
        recognitionStrategy.calculateRevenueRecognitions(contract);
    }