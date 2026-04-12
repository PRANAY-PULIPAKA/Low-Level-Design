package InterviewProblems.InventoryManagementSystem;

import java.util.concurrent.ConcurrentHashMap;

public class Inventory {

    private final ConcurrentHashMap<String, InventoryItem> items =  new ConcurrentHashMap<>();

    public void addProduct(Product product, int quantity){

        items.put(product.getProductId(), new InventoryItem(product, quantity));

    }

    public boolean reserveProduct(String productId, int qty){

        InventoryItem item = items.get(productId);
        if(item == null) return false;
        return item.reserve(qty);
    }

    public void releaseProduct(String productId, int qty){
        InventoryItem item = items.get(productId);
        if(item != null){
            item.release(qty);
        }
    }
    public int getAvailableStock(String productId){
        InventoryItem item = items.get(productId);
        return item == null ? 0 : item.getQuantity();
    }

}
