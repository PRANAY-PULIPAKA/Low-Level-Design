package InterviewProblems.VendingMachine;

public class PaymentState implements VendingState{

    private final VendingMachine machine;

    public PaymentState(VendingMachine machine){
        this.machine = machine;
    }
    @Override
    public void selectProduct(String productName) {
        System.out.println("Product already selected");
    }

    @Override
    public void insertCoin(Coin coin) {
          machine.addBalance(coin.getValue());

          if(machine.getBalance() >= machine.getSelectedProduct().getPrice()){
              machine.setState(machine.getDispenseState());
          }
    }

    @Override
    public void dispense() {
        System.out.println("Please complete payment");
    }
}