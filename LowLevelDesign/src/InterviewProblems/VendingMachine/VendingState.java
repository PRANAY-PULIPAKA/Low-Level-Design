package InterviewProblems.VendingMachine;

public interface VendingState {
    void selectProduct(String productName);
    void insertCoin(Coin coin);
    void dispense();
}
