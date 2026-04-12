package InterviewProblems.VendingMachine;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private final Map<String, Product> products = new HashMap<>();

    public void addProduct(Product product){

        products.put(product.getName(), product);
    }

    public Product getProduct(String name){
        return products.get(name);
    }
}
