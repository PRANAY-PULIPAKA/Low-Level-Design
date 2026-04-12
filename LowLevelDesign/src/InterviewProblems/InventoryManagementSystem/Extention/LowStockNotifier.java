package InterviewProblems.InventoryManagementSystem.Extention;

import java.util.ArrayList;
import java.util.List;

public class LowStockNotifier  {
    private final List<StockObserver> observers = new ArrayList<>();
    public void registerObserver(StockObserver observer) {
        observers.add(observer);
    }

    public void notifyLowStock(String productId, int qty) {
        for (StockObserver observer : observers) {
            observer.onLowStock(productId, qty);
        }
    }
}
