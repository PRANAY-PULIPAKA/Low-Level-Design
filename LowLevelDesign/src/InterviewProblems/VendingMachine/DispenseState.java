package InterviewProblems.VendingMachine;

public class DispenseState implements VendingState{

    private final VendingMachine machine;

    public DispenseState(VendingMachine machine){
        this.machine = machine;
    }

    @Override
    public void selectProduct(String productName) {
        System.out.println("Dispensing is in progress");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Dispensing is in progress");
    }

    @Override
    public void dispense() {

        Product product = machine.getSelectedProduct();
        product.dispense();

        int change = machine.getBalance() - product.getPrice();

        if(change > 0){
            System.out.println("Returning change " + change);
        }

        System.out.println("Dispensed: " + product.getName());

        machine.reset();
        machine.setState(machine.getIdleState());

    }

}
