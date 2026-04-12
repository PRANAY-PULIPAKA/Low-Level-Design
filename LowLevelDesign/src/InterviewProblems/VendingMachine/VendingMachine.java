package InterviewProblems.VendingMachine;

public class VendingMachine {
    private final Inventory inventory = new Inventory();
    private final VendingState idleState;
    private final VendingState paymentState;
    private final VendingState dispenseState;

    private VendingState currentState;
    private Product selectedProduct;
    private int balance;

    public VendingMachine(){
        idleState = new IdleState(this);
        paymentState = new PaymentState(this);
        dispenseState = new DispenseState(this);
        currentState = idleState;
    }

    public void selectProduct(String name){
        currentState.selectProduct(name);
    }

    public void insertCoin(Coin coin){
        currentState.insertCoin(coin);
    }

    public void dispense(){
        currentState.dispense();
    }

    public void setState(VendingState state){
        this.currentState = state;
    }

    public void setSelectedProduct(Product product){
        this.selectedProduct = product;
    }

    void addBalance(int amount){
        balance += amount;
    }

    public Inventory getInventory(){
        return inventory;
    }

    void reset(){
        selectedProduct = null;
        balance = 0;
    }

    int getBalance(){
        return balance;
    }

   public Product getSelectedProduct(){
        return selectedProduct;
    }
    public VendingState getDispenseState(){
        return dispenseState;
    }
    public VendingState getPaymentState() {
        return paymentState;
    }


    public VendingState getIdleState() {
        return idleState;
    }




}
