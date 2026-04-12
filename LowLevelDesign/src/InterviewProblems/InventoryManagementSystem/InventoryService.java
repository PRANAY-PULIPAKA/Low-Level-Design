package InterviewProblems.InventoryManagementSystem;

public class InventoryService {

    private final Inventory inventory;

    public InventoryService(Inventory inventory){
        this.inventory = inventory;
    }

    public boolean placeOrder(Order order){
        for(OrderItem item : order.getItems()){
            if(!inventory.reserveProduct(item.getProductId(), item.getQuantity()){
                rollBack(order);
                return false;
            }
            order.setStatus(OrderStatus.COMPLETED);
            return true;
        }

    }

    private void rollBack(Order order){
        for(OrderItem item : order.getItems()){
            inventory.releaseProduct(item.getProductId(), item.getQuantity());
        }

    }
}
