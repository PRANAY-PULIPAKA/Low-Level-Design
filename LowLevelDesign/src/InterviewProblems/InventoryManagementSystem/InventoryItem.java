package InterviewProblems.InventoryManagementSystem;

public class InventoryItem {

    private final Product product;

    private int quantity;

    public InventoryItem( Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }

    public synchronized  boolean reserve(int qty){
        if(quantity > qty){
            quantity = quantity - qty;
            return true;
        }
        return false;
    }

    public synchronized void release(int qty){
        quantity = quantity + qty;
    }

    public int getQuantity(){
        return quantity;
    }
}
