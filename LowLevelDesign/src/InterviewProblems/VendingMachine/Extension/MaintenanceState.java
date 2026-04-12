package InterviewProblems.VendingMachine.Extension;

import InterviewProblems.VendingMachine.Coin;
import InterviewProblems.VendingMachine.VendingState;

public class MaintenanceState implements VendingState {
    @Override
    public void selectProduct(String productName) {
        System.out.println("Machine under maintenance");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Machine under maintenance");
    }

    @Override
    public void dispense() {
        System.out.println("Machine under maintenance");
    }

    //use machine.setState(new MaintenanceState());
}
