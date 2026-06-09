# YAGNI Principle

> **"You Aren't Gonna Need It"**
---

## 1. What is YAGNI?

**YAGNI** stands for **You Aren't Gonna Need It**.

It is a software design principle that states:

> **Do not add functionality until it is actually needed.**

### The Golden Rule

```
If the requirement does not exist TODAY → do NOT build it TODAY.
```

---

## 2. Why YAGNI Exists

### The Cost of Speculative Code

| Problem | Impact |
|---|---|
| Code written that's never used | Wasted dev time |
| Unused abstractions | Increased complexity |
| More code to test & maintain | Higher bug surface area |
| Future requirements change | Speculative code becomes dead code |
| Cognitive load increases | Slower onboarding, slower velocity |

Studies in software engineering consistently show that **a significant portion of features built are rarely or never used**. YAGNI directly fights this waste.

---

## 3. Core Philosophy

### YAGNI is built on 3 pillars:

```
1. BUILD what you need NOW
2. TRUST that you can add more LATER
3. ACCEPT that requirements WILL change
```

### Underlying Assumptions

- Refactoring is **cheap and safe** (requires good tests)
- Future requirements are **uncertain**
- Code has a **cost to maintain**, not just to write
- Simple code is **easier to extend** when the real need appears

---

## 4. YAGNI in the SDLC

```
Requirement Analysis  →  Only model what's asked
Design               →  No extra layers/abstractions
Implementation       →  No placeholder/future hooks
Code Review          →  Flag unused/speculative code
Testing              →  Test what exists, not what "might" exist
Refactoring          →  Add abstraction when 3rd use case emerges (Rule of Three)
```

---

## 5. Bad Practices — Anti-Patterns

### ❌ BAD PRACTICE 1 — Speculative Generalization

```java
// Requirement: Store a User's name and email. Nothing else.

// ❌ BAD — Adding fields "we might need later"
public class User {
    private String name;
    private String email;

    // NOT required yet — pure speculation
    private String phoneNumber;
    private String address;
    private String linkedInProfile;
    private String twitterHandle;
    private Date deletedAt;           // soft delete "just in case"
    private String preferredLanguage; // "for i18n someday"
    private boolean isPremium;        // "billing will come eventually"
}
```

**Problem:** Every unused field is a maintenance burden. Future devs wonder if these are used somewhere. Tests must account for them. DB schemas bloat.

---

### ❌ BAD PRACTICE 2 — Premature Abstraction / Plugin Architecture

```java
// Requirement: Send a welcome email on user registration.

// ❌ BAD — Building a full notification "framework" for one email
public interface NotificationChannel {
    void send(Notification notification);
}

public interface NotificationRouter {
    void route(Notification notification, List<NotificationChannel> channels);
}

public interface NotificationTemplate {
    String render(Map<String, Object> context);
}

public class EmailChannel implements NotificationChannel { ... }
public class SmsChannel implements NotificationChannel { ... }       // NOT needed
public class PushChannel implements NotificationChannel { ... }      // NOT needed
public class SlackChannel implements NotificationChannel { ... }     // NOT needed

// When you only needed:
public class EmailService {
    public void sendWelcomeEmail(String toAddress) {
        // send the email
    }
}
```

**Problem:** You've written 200 lines for a 10-line requirement. When requirements do change, the abstraction is often wrong anyway.

---

### ❌ BAD PRACTICE 3 — Unused Method Parameters / Flags

```java
// Requirement: Fetch all active products.

// ❌ BAD — Adding parameters "for future flexibility"
public List<Product> getProducts(
    boolean activeOnly,       // hardcoded true everywhere for now
    boolean includeDeleted,   // always false, not required
    String sortBy,            // always null, not required
    int version               // "in case we version this API later"
) {
    // ...
}

// ✅ GOOD
public List<Product> getActiveProducts() {
    // ...
}
```

**Problem:** Boolean flags are a code smell. Callers have no idea what `getProducts(true, false, null, 1)` means.

---

### ❌ BAD PRACTICE 4 — Dead Code / TODO Stubs Left In

```java
// ❌ BAD — Writing placeholder methods for "future" features
public class OrderService {

    public void placeOrder(Order order) {
        validateOrder(order);
        saveOrder(order);
        // TODO: implement loyalty points deduction someday
        // TODO: notify warehouse (future sprint)
        // TODO: fraud detection hook
    }

    // Stub methods that do nothing — just noise
    private void deductLoyaltyPoints(Order order) {
        // will implement later
    }

    private void notifyWarehouse(Order order) {
        // coming soon
    }
}
```

**Problem:** TODOs rot. Stub methods mislead. Future developers can't distinguish "placeholder" from "broken."

---

### ❌ BAD PRACTICE 5 — Over-Engineering Data Structures

```java
// Requirement: Count page visits for a single page.

// ❌ BAD — Building a generic analytics engine
public class AnalyticsEngine<T extends Trackable> {
    private Map<String, List<TimestampedEvent<T>>> eventStore;
    private List<AnalyticsPlugin> plugins;
    private RetentionPolicy retentionPolicy;

    public void track(T entity, EventType type, Map<String, Object> metadata) { ... }
    public AnalyticsReport<T> generateReport(ReportConfig config) { ... }
}

// ✅ GOOD — for now
public class PageVisitCounter {
    private int visitCount = 0;

    public void recordVisit() {
        visitCount++;
    }

    public int getVisitCount() {
        return visitCount;
    }
}
```

---

## 6. Good Practices — YAGNI Done Right

### ✅ GOOD PRACTICE 1 — Build Exactly What's Needed

```java
// Requirement: A user has a name and email. Login via email.

// ✅ GOOD — Minimal, precise model
public class User {
    private final String name;
    private final String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
}
```

When phone number is required — add it then. When soft delete is required — add it then.

---

### ✅ GOOD PRACTICE 2 — Simple Service, Refactor When Needed

```java
// Requirement: Send welcome email on registration.

// ✅ GOOD — Concrete, focused, testable
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendWelcomeEmail(String toAddress, String userName) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toAddress);
        message.setSubject("Welcome, " + userName + "!");
        message.setText("Thanks for signing up.");
        mailSender.send(message);
    }
}

// Later, when SMS is required → extract interface THEN.
// The Rule of Three: abstract on the 3rd duplication, not the 1st.
```

---

### ✅ GOOD PRACTICE 3 — Clean API Surface

```java
// ✅ GOOD — Method does one thing, no speculative params
public List<Product> getActiveProducts() {
    return productRepository.findByStatus(ProductStatus.ACTIVE);
}

// When sorting IS required, add it with the ticket:
public List<Product> getActiveProducts(Sort sort) {
    return productRepository.findByStatus(ProductStatus.ACTIVE, sort);
}
```

---

### ✅ GOOD PRACTICE 4 — No Stub Methods, No Dead Hooks

```java
// ✅ GOOD — Clean, honest implementation
public class OrderService {

    private final OrderRepository orderRepository;
    private final EmailService emailService;

    public void placeOrder(Order order) {
        validateOrder(order);
        Order saved = orderRepository.save(order);
        emailService.sendOrderConfirmation(saved);
    }

    private void validateOrder(Order order) {
        if (order.getItems().isEmpty()) {
            throw new IllegalArgumentException("Order must have at least one item.");
        }
    }
}
// Nothing hidden. Nothing speculative. Nothing unfinished.
```

---

### ✅ GOOD PRACTICE 5 — Evolve Design Incrementally

```java
// Sprint 1: Single payment method — Stripe only
public class PaymentService {
    public void charge(String customerId, int amountInPaise) {
        stripeClient.charge(customerId, amountInPaise);
    }
}

// Sprint 5: PayPal added — NOW extract interface
public interface PaymentGateway {
    void charge(String customerId, int amountInPaise);
}

public class StripeGateway implements PaymentGateway { ... }
public class PayPalGateway implements PaymentGateway { ... }

// Abstraction introduced when it has real value, not "just in case."
```

---

## 7. YAGNI vs Related Principles

| Principle | What It Says | Relationship to YAGNI |
|---|---|---|
| **YAGNI** | Don't build what isn't needed | Core principle |
| **KISS** | Keep It Simple, Stupid | YAGNI achieves KISS by removing speculative code |
| **DRY** | Don't Repeat Yourself | Complement — but don't abstract *too early* (Rule of Three) |
| **SOLID** | Design principles for OOP | YAGNI prevents over-applying SOLID prematurely |
| **Rule of Three** | Abstract on 3rd duplication | Practical guide for *when* to stop being YAGNI and start abstracting |

### YAGNI ≠ "Write Bad Code"

YAGNI does **not** mean:
- Skip error handling
- Ignore known edge cases
- Write unreadable code
- Avoid tests

YAGNI means: **don't build features or abstractions that have no current requirement.**

---

## 8. Common Misconceptions

| Misconception | Reality |
|---|---|
| "YAGNI means no design upfront" | You still design — just don't *implement* what isn't needed |
| "YAGNI conflicts with scalability" | Build for today's load; scale when metrics demand it |
| "YAGNI means no interfaces" | Use interfaces when you have 2+ implementations — not 'just in case' |
| "YAGNI means no refactoring later" | Refactoring is how YAGNI works — you rely on doing it safely later |
| "YAGNI is for startups only" | It applies everywhere — large codebases suffer MORE from speculative code |

---

## 9. Interview Questions & Model Answers

---

### Q1. What is the YAGNI principle and where did it originate?

**Answer:**
YAGNI stands for *You Aren't Gonna Need It*, coined by Ron Jeffries as part of Extreme Programming (XP). It states that a developer should not add functionality until it is actually required. The principle fights speculative development — writing code for imagined future requirements that may never arrive or may arrive in a completely different form. Every line of code has a cost: to write, test, review, and maintain. YAGNI keeps that cost tied to real value.

---

### Q2. How does YAGNI differ from KISS and DRY?

**Answer:**
All three reduce complexity, but they address different dimensions:
- **YAGNI** — Don't implement features that aren't needed *yet*.
- **KISS** — Keep implementations simple when you do build them.
- **DRY** — Eliminate duplication once it actually exists.

YAGNI and DRY can tension each other: DRY encourages abstraction, but YAGNI says don't abstract until you have a real second (or third) case. The **Rule of Three** bridges them: abstract on the third repetition, not the first.

---

### Q3. Give a Java example of violating YAGNI and how you'd fix it.

**Answer:**

```java
// ❌ VIOLATION — adding fields not required by any story
public class Employee {
    private String name;
    private String department;
    private String linkedInUrl;          // no requirement
    private String emergencyContact;     // no requirement
    private boolean isRemote;            // no requirement
    private List<String> certifications; // no requirement
}

// ✅ FIX — model only what the current feature needs
public class Employee {
    private final String name;
    private final String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    // getters only
}
```

When HR requests emergency contact storage — add it then, with a test, in a PR that references that requirement.

---

### Q4. How does YAGNI relate to Agile development?

**Answer:**
YAGNI is a natural fit for Agile because Agile embraces change. In Agile:
- Requirements are delivered as user stories in sprints.
- Future sprints are not fully defined.
- Building for anticipated future stories adds cost based on guesses.

YAGNI encourages developers to trust the sprint boundary — implement what this sprint requires, leave future sprints to define future needs. It also pairs with Agile's emphasis on working software over speculation, and continuous refactoring keeps the codebase ready to evolve.

---

### Q5. Isn't YAGNI risky? What if we need to add that feature later and the architecture doesn't support it?

**Answer:**
This is the most important counterargument. YAGNI assumes two things:
1. **Tests exist** — so refactoring is safe.
2. **Code is clean** — so extension points can be added without rewriting everything.

If those conditions hold, adding a feature later is genuinely cheaper than maintaining speculative code now. The risk is real when codebases have poor test coverage or high coupling — in those cases, the solution is better tests and cleaner design, not speculative features. Also, experience matters: senior engineers learn to distinguish *fundamental architectural decisions* (e.g., choosing SQL vs NoSQL) from *speculative features* (e.g., adding 10 unused entity fields).

---

### Q6. How do you handle it when a product manager says "we'll need X in the future, just add it now"?

**Answer:**
This is a communication and prioritization conversation, not a technical one. My approach:

1. **Acknowledge the concern** — "I understand we're thinking ahead about X."
2. **Quantify the cost** — "Adding it now means writing, testing, and maintaining code that isn't delivering value yet."
3. **Highlight the risk** — "Requirements often change between now and when we actually need it — we might build the wrong version of X."
4. **Offer an alternative** — "Let's design the current code to be open for extension, and when X is a real requirement, we'll implement it cleanly and correctly."

The goal is a clean, extensible codebase — not a featureless one. YAGNI doesn't mean saying no to features; it means building them when they're real requirements, not assumptions.

---

### Q7. How does YAGNI interact with design patterns?

**Answer:**
Design patterns are solutions to recurring problems. Applying a pattern before the problem exists is a YAGNI violation.

```java
// ❌ Applying Strategy Pattern speculatively
// Requirement: Calculate order total with a flat 10% discount.
public interface DiscountStrategy {
    double apply(double total);
}
public class FlatDiscountStrategy implements DiscountStrategy { ... }
public class PercentageDiscountStrategy implements DiscountStrategy { ... }
public class LoyaltyDiscountStrategy implements DiscountStrategy { ... }

// ✅ YAGNI — start here
public double calculateTotal(double subtotal) {
    return subtotal * 0.90; // 10% discount per spec
}

// When a second discount type appears → introduce the Strategy Pattern then.
```

Patterns should emerge from real complexity, not be imposed on anticipated complexity.

---

### Q8. How do you balance YAGNI with writing extensible code?

**Answer:**
The balance lives in *structure* vs *features*:

- **Structure** — Use good naming, small methods, single responsibility, clear module boundaries. This is not YAGNI — this is good design.
- **Features** — Don't implement features, fields, or abstractions without a requirement.

Concretely:
- **Do** write a service class with clean method boundaries → easy to extend.
- **Don't** add 6 unused method parameters "for flexibility."
- **Do** name your domain concepts clearly.
- **Don't** build a plugin system for one implementation.

YAGNI doesn't fight extensibility. It fights *the wrong kind of extensibility* — guessing which extension points you'll need.

---

### Q9. What is the "Rule of Three" and how does it complement YAGNI?

**Answer:**
The Rule of Three says: **abstract on the third repetition, not the first or second.**

- **First time** — Write it directly.
- **Second time** — Notice the duplication. Extract a local helper if trivial.
- **Third time** — Now the pattern is real. Extract a proper abstraction.

This complements YAGNI because it prevents premature abstraction (a YAGNI violation) while also preventing DRY violations. It gives developers a concrete signal: "now I have enough evidence that this abstraction is real and stable."

```java
// 1st use: just write it
double taxForDelhi = price * 0.18;

// 2nd use: hmm, similar
double taxForMumbai = price * 0.18;

// 3rd use: now extract
public double calculateGST(double price, double rate) {
    return price * rate;
}
```

---

### Q10. How would you identify YAGNI violations in a code review?

**Answer:**
Red flags to look for:

| Signal | Example |
|---|---|
| Unused fields or parameters | `private String futureField;` |
| Boolean flags with no variety | `getUsers(true, false, false)` |
| Interfaces with only one implementation | `UserLoader` implemented by `DatabaseUserLoader` only |
| TODO/stub methods | `// TODO: implement later` |
| Generic frameworks for single use cases | Event bus for one event type |
| Config flags that are never toggled | Feature flags always `true` |
| Over-parameterized methods | Method takes 8 params, 4 are always null |

During review I would ask: *"Is there a current user story or requirement that drives this code?"* If the answer is no — flag it and suggest removing it or opening a separate ticket if it genuinely belongs in the backlog.

---

## Summary Cheat Sheet

```
✅ DO                              ❌ DON'T
─────────────────────────────────────────────────────────
Build for today's requirements     Build for imagined future ones
Add abstraction at 3rd use case    Add abstraction at 1st use case
Keep models lean                   Add speculative fields
Write clean, extensible structure  Write plug-in systems for 1 use case
Refactor when the need is clear    Write TODOs and stubs
Trust your test suite              Fear refactoring (fix tests instead)
```

---

*YAGNI is not laziness — it is discipline. It takes more courage to say "we don't need that yet" than to build something "just in case."*