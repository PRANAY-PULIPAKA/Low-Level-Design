package InterviewProblems.VendingMachine;

public class Product {
    private final String id;
    private final String name;
    private final ProductCategory category;
    private final int price;
    private int quantity;

    public Product(String id, String name, ProductCategory category, int price, int quantity){
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;

    }

    public boolean isAvailable(){
       return quantity > 0;
    }

    public void dispense(){
        if(quantity <= 0){
            throw  new IllegalStateException("No stock Available");
        }
        quantity--;
    }

    public int getPrice(){
        return price;
    }

    public String getName(){
        return name;
    }

}
