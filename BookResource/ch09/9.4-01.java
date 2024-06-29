    public class ApplicationService {
        protected EmailGateway getEmailGateway() {
            //傳回一個EmailGateway的執行個體
        }
        protected IntegrationGateway getIntegrationGateway() {
            //傳回一個IntegrationGateway的執行個體
        }
    }
    public interface EmailGateway {
        void sendEmailMessage(String toAddress, String subject, String body);
    }
    public interface IntegrationGateway {
        void publishRevenueRecognitionCalculation(Contract contract);
    }
    public class RecognitionService extends ApplicationService {
        public void calculateRevenueRecognitions(long contractNumber) {
            Contract contract = Contract.readForUpdate(contractNumber);
            contract.calculateRecognitions();
            getEmailGateway().sendEmailMessage(
                contract.getAdministratorEmailAddress(),
                "RE: Contract #" + contractNumber,
                contract + " has had revenue recognitions calculated.");
            getIntegrationGateway().publishRevenueRecognitionCalculation(contract);
        }
        public Money recognizedRevenue(long contractNumber, Date asOf) {
            return Contract.read(contractNumber).recognizedRevenue(asOf);
        }
    }