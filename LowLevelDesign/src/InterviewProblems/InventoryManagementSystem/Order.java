package InterviewProblems.InventoryManagementSystem;

import java.util.List;

public class Order {

    private final String orderId;
    private final List<OrderItem> items;
    private OrderStatus status;

    public Order(String orderId, List<OrderItem> items){
        this.orderId = orderId;
        this.items = items;
        this.status = OrderStatus.CREATED;
    }
    public  List<OrderItem> getItems(){
        return items;
    }
    public void setStatus(OrderStatus status){
        this.status = status;
    }

}
