package InterviewProblems.InventoryManagementSystem.Extention;

import InterviewProblems.InventoryManagementSystem.Product;

public class InventoryItem {
    private final Product product;
    private int quantity;
    private final int LOW_STOCK_THRESHOLD = 5;
    private final LowStockNotifier notifier;

    public InventoryItem(Product product, int quantity, LowStockNotifier notifier) {
        this.product = product;
        this.quantity = quantity;
        this.notifier = notifier;
    }

    public synchronized boolean reserve(int qty) {
        if (quantity >= qty) {
            quantity -= qty;

            if (quantity <= LOW_STOCK_THRESHOLD) {
                notifier.notifyLowStock(product.getProductId(), quantity);
            }
            return true;
        }
        return false;
    }

    public synchronized void release(int qty) {
        quantity += qty;
    }

    public int getQuantity() {
        return quantity;
    }
}
