package InterviewProblems.InventoryManagementSystem.Extention;

public interface StockObserver {
    void onLowStock(String productId, int remainingQuantity);
}

