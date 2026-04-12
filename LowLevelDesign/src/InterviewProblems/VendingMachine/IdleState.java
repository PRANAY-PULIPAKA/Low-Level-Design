package InterviewProblems.VendingMachine;

public class IdleState implements  VendingState{

    private final VendingMachine machine;

    public IdleState(VendingMachine machine){
        this.machine = machine;
    }
    @Override
    public void selectProduct(String productName) {
        Product product = machine.getInventory().getProduct(productName);

        if(product == null || !product.isAvailable()){
            System.out.println("Product not available");
            return;
        }

        machine.setSelectedProduct(product);
        machine.setState(machine.getPaymentState());
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please select the product first");
    }

    @Override
    public void dispense() {
        System.out.println("No product selected");
    }

}
