# Single Responsibility Principle (SRP)

The **Single Responsibility Principle (SRP)** is the first principle of the SOLID design guidelines. It states that:

> **"A class should have one, and only one, reason to change."**

In other words, a class should do one thing and do it well. If a class handles multiple responsibilities, changes to one business requirement can accidentally break or require modifications to entirely unrelated features.

---

## ❌ The Bad Way: Violating SRP

Below is a classic "God Class" implementation of an `Invoice`. It mixes business math, presentation formatting, and database management into a single entity.

```java
public class Invoice {
    private double amount;
    private String customerName;

    public Invoice(double amount, String customerName) {
        this.amount = amount;
        this.customerName = customerName;
    }

    // Responsibility 1: Business Logic
    public double calculateTotalWithTax() {
        return amount * 1.18; // 18% tax
    }

    // Responsibility 2: Presentation Logic
    public void printInvoice() {
        System.out.println("Invoice for: " + customerName + " | Total: " + calculateTotalWithTax());
    }

    // Responsibility 3: Persistence Logic
    public void saveToDatabase() {
        System.out.println("Connecting to DB and saving invoice...");
    }
}

```
# Why is this design fragile?

### This class has three distinct reasons to change:

>Finance / Accounting changes: The tax calculation rate or strategy changes.

>UX / UI changes: The format of the printed output changes (e.g., changing from the console to HTML or PDF output).

>Database / DevOps changes: The storage layer changes (e.g., migrating from SQL to MongoDB).


# The Good Way: Adhering to SRP

To fix this, we decouple the tight connections by splitting the logic into three separate, highly specialized classes. Each class is now driven by exactly one business actor.
> 1. The Core Domain Object (Business Logic)

Manages only the data properties and calculations directly essential to an invoice entity.

public class Invoice {
private double amount;
private String customerName;

```java
    public class Invoice {
    
        private double amount;
        private String customerName;

        public Invoice(double amount, String customerName) {
            this.amount = amount;
            this.customerName = customerName;
        }
    
        public double getAmount() {
            return amount;
        }
    
        public String getCustomerName() { 
            return customerName;
        }

        public double calculateTotalWithTax() {
            return amount * 1.18;
        }
    }
```
> 2. The Printer (Presentation Logic)

Responsible solely for rendering the invoice data for end-users or logging systems.

```java
public class InvoicePrinter {
    
    public void print(Invoice invoice) {
        System.out.println("Invoice for: " + invoice.getCustomerName() + " | Total: " + invoice.calculateTotalWithTax());
    }
}
```

> 3. The Repository (Persistence Logic)

Responsible solely for database interactions, queries, and connection handling.

````java
public class InvoiceRepository {
    
    public void save(Invoice invoice) {
        System.out.println("Saving invoice for " + invoice.getCustomerName() + " to the database.");
    }
}
````
# How It Looks in Action

>In your application's entry point, you orchestrate these specialized tools cleanly together:

````java
public class Main {

    public static void main(String[] args) {
        // Create the core domain object
        Invoice invoice = new Invoice(100.0, "Alice");

        // Inject or instantiate specific handlers
        InvoicePrinter printer = new InvoicePrinter();
        InvoiceRepository repository = new InvoiceRepository();

        // Execute distinct operations
        printer.print(invoice);
        repository.save(invoice);
    }
}
````

# 💡 Top 3 Interview Follow-Up Questions
>1. "But now you have 3 classes instead of 1. Doesn't that just create more boilerplate code?"
>
> Answer: Yes, it does increase the total file count. However, it significantly lowers cognitive load. If a bug occurs within our data storage logic, a developer knows precisely to look at InvoiceRepository without the fear of accidentally altering the calculation formulas. The code shifts from being a black box to self-documenting blocks.

>2. "How would you unit test this refactored version compared to the old one?"
>
>Answer: In the original coupled structure, testing calculateTotalWithTax() required dealing with console streams or mocking database clients within the test environment. With the SRP compliant layout, Invoice is a pure entity. I can write a fast, dependency-free unit test checking inputs against outputs instantly.

>3. "Where do you draw the line? Should every single method have its own class?"
>
>Answer: No, doing that introduces over-engineering. A good rule of thumb is to define a "responsibility" by the business actor or stakeholder requesting a change. The finance team cares about tax formulas; the DBA cares about indexing and data persistence; the front-end team cares about formatting. Because these represent three entirely different business vectors, they deserve three individual classes.