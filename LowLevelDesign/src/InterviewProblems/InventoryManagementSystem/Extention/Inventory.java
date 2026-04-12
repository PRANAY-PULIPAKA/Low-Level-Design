package InterviewProblems.InventoryManagementSystem.Extention;

import InterviewProblems.InventoryManagementSystem.Product;

import java.util.concurrent.ConcurrentHashMap;

public class Inventory {

        private final ConcurrentHashMap<String, InventoryItem> items = new ConcurrentHashMap<>();
        private final LowStockNotifier notifier = new LowStockNotifier();

        public void addObserver(StockObserver observer) {
            notifier.registerObserver(observer);
        }

        public void addProduct(Product product, int quantity) {
            items.put(product.getProductId(),
                    new InventoryItem(product, quantity, notifier));
        }

        public boolean reserveProduct(String productId, int qty) {
            InventoryItem item = items.get(productId);
            if (item == null) return false;
            return item.reserve(qty);
        }

        public void releaseProduct(String productId, int qty) {
            InventoryItem item = items.get(productId);
            if (item != null) {
                item.release(qty);
            }
        }
}
