package InterviewProblems.InventoryManagementSystem.Extention;

public class EmailAlertObserver implements StockObserver {

    @Override
    public void onLowStock(String productId, int remainingQuantity) {
        System.out.println("EMAIL ALERT: Product " + productId +
                " low stock. Remaining: " + remainingQuantity);
    }
}
