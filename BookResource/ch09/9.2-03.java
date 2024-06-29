class Contract...

    private Product product;
    private Money revenue;
    private MfDate whenSigned;
    private Long id;
    public Contract(Product product, Money revenue, MfDate whenSigned) {
        this.product = product; this.revenue = revenue; this.whenSigned = whenSigned;
    }

class Product...

    private String name;
    private RecognitionStrategy recognitionStrategy;
    public Product(String name, RecognitionStrategy recognitionStrategy) {
        this.name = name;
        this.recognitionStrategy = recognitionStrategy;
    }
    public static Product newWordProcessor(String name) {
        return new Product(name, new CompleteRecognitionStrategy());
    }
    public static Product newSpreadsheet(String name) {
        return new Product(name, new ThreeWayRecognitionStrategy(60, 90));
    }
    public static Product newDatabase(String name) {
        return new Product(name, new ThreeWayRecognitionStrategy(30, 60));
    }

class RecognitionStrategy...

    abstract void calculateRevenueRecognitions(Contract contract);

class CompleteRecognitionStrategy...

    void calculateRevenueRecognitions(Contract contract) {
        contract.addRevenueRecognition(new RevenueRecognition(contract.getRevenue(),
                                                            contract.getWhenSigned()));
    }

class ThreeWayRecognitionStrategy...

    private int firstRecognitionOffset;
    private int secondRecognitionOffset;
    public ThreeWayRecognitionStrategy(int firstRecognitionOffset, int secondRecognitionOffset)
    {
        this.firstRecognitionOffset = firstRecognitionOffset;
        this.secondRecognitionOffset = secondRecognitionOffset;
    }
    void calculateRevenueRecognitions(Contract contract) {
        Money[] allocation = contract.getRevenue().allocate(3);
        contract.addRevenueRecognition(new RevenueRecognition
            (allocation[0], contract.getWhenSigned()));
        contract.addRevenueRecognition(new RevenueRecognition
            (allocation[1], contract.getWhenSigned().addDays(firstRecognitionOffset)));
        contract.addRevenueRecognition(new RevenueRecognition
            (allocation[2], contract.getWhenSigned().addDays(secondRecognitionOffset)));
    }