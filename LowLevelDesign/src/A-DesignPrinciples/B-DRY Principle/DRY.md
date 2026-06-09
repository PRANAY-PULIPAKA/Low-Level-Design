# DRY Principle — Don't Repeat Yourself

> **"Every piece of knowledge must have a single, unambiguous, authoritative representation within a system."**

In plain terms: **if you've written the same logic twice, something is wrong.** DRY isn't just about copy-pasting code — it applies to business logic, configuration, database schemas, documentation, and even test setup.

---

## ❌ The Bad Way: Violating DRY

### Scenario: An e-commerce app that applies discounts

```java
public class OrderService {

    public double calculateFinalPrice(double price, String customerType) {
        if (customerType.equals("PREMIUM")) {
            return price * 0.80; // 20% discount
        }
        return price;
    }
}

public class InvoiceService {

    public double getInvoiceTotal(double price, String customerType) {
        // ❌ Same discount logic copy-pasted here
        if (customerType.equals("PREMIUM")) {
            return price * 0.80;
        }
        return price;
    }
}

public class CartService {

    public double previewCartTotal(double price, String customerType) {
        // ❌ And again here — three sources of truth for the same rule
        if (customerType.equals("PREMIUM")) {
            return price * 0.80;
        }
        return price;
    }
}
```

### Why is this design fragile?

The discount rate `0.80` (20% off) is hardcoded in **three different places**.

| What changes | How many files break |
|---|---|
| Discount changes from 20% → 25% | 3 files to update manually |
| A new customer type `VIP` is introduced | 3 files to update |
| A developer updates only 2 of the 3 | 🐛 Silent logic bug in production |

This is the **real danger of WET code** (Write Everything Twice) — not just redundancy, but **inconsistency over time**.

---

## ✅ The Good Way: Adhering to DRY

Extract the repeated logic into a **single authoritative location**.

### Step 1: Create the Single Source of Truth

```java
public class DiscountCalculator {

    // ✅ One place. One rule. One owner.
    public double applyDiscount(double price, String customerType) {
        if (customerType.equals("PREMIUM")) {
            return price * 0.80; // 20% discount
        }
        if (customerType.equals("VIP")) {
            return price * 0.70; // 30% discount — easy to add new tiers
        }
        return price;
    }
}
```

### Step 2: Inject and Reuse Across Services

```java
public class OrderService {

    private final DiscountCalculator discountCalculator;

    public OrderService(DiscountCalculator discountCalculator) {
        this.discountCalculator = discountCalculator;
    }

    public double calculateFinalPrice(double price, String customerType) {
        return discountCalculator.applyDiscount(price, customerType); // ✅ Delegated
    }
}

public class InvoiceService {

    private final DiscountCalculator discountCalculator;

    public InvoiceService(DiscountCalculator discountCalculator) {
        this.discountCalculator = discountCalculator;
    }

    public double getInvoiceTotal(double price, String customerType) {
        return discountCalculator.applyDiscount(price, customerType); // ✅ Same source
    }
}

public class CartService {

    private final DiscountCalculator discountCalculator;

    public CartService(DiscountCalculator discountCalculator) {
        this.discountCalculator = discountCalculator;
    }

    public double previewCartTotal(double price, String customerType) {
        return discountCalculator.applyDiscount(price, customerType); // ✅ Consistent
    }
}
```

### Step 3: Wire It All Together

```java
public class Main {

    public static void main(String[] args) {
        DiscountCalculator calculator = new DiscountCalculator();

        OrderService orderService     = new OrderService(calculator);
        InvoiceService invoiceService = new InvoiceService(calculator);
        CartService cartService       = new CartService(calculator);

        double price        = 100.0;
        String customerType = "PREMIUM";

        System.out.println("Order Total:   " + orderService.calculateFinalPrice(price, customerType));   // 80.0
        System.out.println("Invoice Total: " + invoiceService.getInvoiceTotal(price, customerType));     // 80.0
        System.out.println("Cart Preview:  " + cartService.previewCartTotal(price, customerType));       // 80.0
    }
}
```

Now if the discount changes, **you update exactly one file** and every service automatically reflects it.

---

## DRY Beyond Code — It Applies Everywhere

Most developers think DRY is only about avoiding copy-pasted methods. It's much broader.

### ① Constants and Magic Numbers

```java
// ❌ WET — the number 18 scattered everywhere
public double calculateTax(double amount) { return amount * 0.18; }
public boolean isTaxApplicable(double rate) { return rate == 0.18; }
public String getTaxLabel() { return "GST @ 18%"; }

// ✅ DRY — declared once, referenced everywhere
public class TaxConstants {
    public static final double GST_RATE = 0.18;
    public static final String GST_LABEL = "GST @ " + (int)(GST_RATE * 100) + "%";
}
```

### ② Validation Logic

```java
// ❌ WET — email validation duplicated in controller, service, and entity
// UserController.java
if (email == null || !email.contains("@")) throw new IllegalArgumentException("Bad email");

// UserService.java
if (email == null || !email.contains("@")) throw new RuntimeException("Invalid email");

// ✅ DRY — extracted to a shared validator
public class EmailValidator {
    public static void validate(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address: " + email);
        }
    }
}
// Now both controller and service call EmailValidator.validate(email)
```

### ③ Test Setup (DRY in Tests)

```java
// ❌ WET — every test recreates the same Invoice object from scratch
@Test void testPremiumDiscount() {
    Invoice invoice = new Invoice(100.0, "Alice", "PREMIUM"); // duplicated
    ...
}
@Test void testVipDiscount() {
    Invoice invoice = new Invoice(100.0, "Alice", "PREMIUM"); // duplicated again
    ...
}

// ✅ DRY — use @BeforeEach or a factory method
Invoice invoice;

@BeforeEach
void setUp() {
    invoice = new Invoice(100.0, "Alice", "PREMIUM"); // single source
}
```

---

## ⚠️ The Advanced Trap: Over-DRY in Microservices

This is where **senior engineers are separated from juniors** in interviews.

### The Scenario

Your company has two microservices:

```
billing-service/
notification-service/
```

Both need a `User` POJO and email validation. A developer creates a shared library:

```
shared-commons/
  └── UserDTO.java
  └── EmailValidator.java
```

Both services now depend on `shared-commons`. Looks clean, right?

### Why This Backfires

```
billing-service     ──┐
                       ├──► shared-commons v1.2
notification-service ──┘

// Later, billing-service needs a new field on UserDTO:
// shared-commons bumped to v1.3

billing-service     ──────► shared-commons v1.3  ✅
notification-service ─────► shared-commons v1.2  ❌ (now out of sync or forced to upgrade)
```

**You've traded code duplication for deployment coupling.** Now:
- A `billing-service` change can **break `notification-service`** at build or runtime.
- Both services must be released in lockstep — defeating the independence microservices promise.
- The shared library becomes a **"distributed monolith"** in disguise.

### The Right Approach: Tolerate Small Duplication at Service Boundaries

```
billing-service/
  └── UserDTO.java        ← owns its own copy
  └── EmailValidator.java ← owns its own copy

notification-service/
  └── UserDTO.java        ← its own copy, can evolve independently
  └── EmailValidator.java ← its own copy
```

> **Rule of Thumb:** Within a service or module, DRY aggressively. Across service boundaries, prefer duplication over coupling. A few extra lines of code is far cheaper than a distributed deployment dependency.

This is known as the **"Rule of Three"** in practice — only extract a shared abstraction after you've seen the duplication in **three or more independent places**, and only if they are truly governed by the same business rule.

---

## DRY vs. DAMP in Tests

A nuance worth knowing: test code follows a slightly different philosophy.

| | DRY | DAMP |
|---|---|---|
| Stands for | Don't Repeat Yourself | Descriptive And Meaningful Phrases |
| Goal | Eliminate duplication | Maximize readability |
| Risk of over-applying | Tests become hard to follow | Some setup repeated |
| Best for | Production code | Test code |

**DAMP** accepts *some* repetition in tests if it keeps each test self-contained and readable at a glance. A test that needs to jump to a helper to understand what it's setting up is a test that's harder to debug at 2am.

---

## 💡 Top Interview Questions on DRY

### 1. "Isn't DRY just about not copy-pasting code?"

**Expected Answer:** No. DRY is about eliminating **duplicated knowledge**, not just duplicated text. Two pieces of code can look identical but represent different business rules — merging them would be wrong. Conversely, two pieces of code can look different but encode the same rule — that's still a DRY violation. The key word in the definition is *knowledge*.

---

### 2. "When should you NOT apply DRY?"

**Expected Answer:** At **service and module boundaries**, especially in microservices. Sharing a library between services creates tight deployment coupling. A change to the shared library forces all consumers to upgrade together, breaking independent deployability. A small amount of duplication is healthier than a distributed monolith. Also, in test code, DAMP is often preferable to DRY.

---

### 3. "How does DRY relate to SRP and other SOLID principles?"

**Expected Answer:** They complement each other. SRP tells you *where* logic belongs (one class, one reason to change). DRY tells you it should exist in *only one place*. A DRY violation is often a SRP violation in disguise — if two classes both compute tax, neither fully owns that responsibility.

---

### 4. "How would you unit test a DRY codebase versus a WET one?"

**Expected Answer:** In a DRY codebase, you test `DiscountCalculator` once with thorough cases. Every service that uses it inherits correctness by composition. In a WET codebase, you must test the same logic in every class that duplicated it, and one day a test gets missed — leading to a class that behaves correctly in isolation but incorrectly in production.

---

### 5. "What is the Rule of Three?"

**Expected Answer:** Don't abstract on the first or second occurrence of duplication — wait until you see it a third time. By then, the pattern is stable enough that your abstraction won't be wrong. Premature DRY-ing based on superficial similarity creates the wrong abstraction, which is **harder to fix than duplication** (because now consumers depend on it).

---

## Quick Reference

| Smell | DRY Fix |
|---|---|
| Same `if-else` in 3 classes | Extract to a `Strategy` or `Calculator` class |
| Magic numbers scattered everywhere | Centralize in a `Constants` class |
| Same validation in controller + service | Extract to a `Validator` utility |
| Copy-pasted `@BeforeEach` across test files | Use a shared test factory or base test class |
| Shared POJO across microservices | Duplicate it per service; avoid shared libraries |
| Same SQL query built in two DAOs | Create a named query or repository method |