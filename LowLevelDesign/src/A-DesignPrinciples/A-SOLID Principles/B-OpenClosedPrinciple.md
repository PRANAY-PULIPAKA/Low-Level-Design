# The Open-Closed Principle (OCP)

The **Open-Closed Principle (OCP)** is the "O" in **SOLID** and one of the most critical design principles you will be tested on in SDE interviews—especially during Object-Oriented Design (OOD) and Low-Level Design (LLD) rounds.

At its core, OCP dictates:
> **Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification.**

In plain English: You should be able to add new functionality to your code **without touching or changing the existing code** that already works.

---

## Why OCP Matters in the Real World

Imagine you have a shipping calculator that handles FedEx and UPS. If a new requirement comes in to add DHL, and you have to modify your core `ShippingService` class to add an `if/else` block for DHL, you are violating OCP.

**The Risk:** Every time you modify that core class, you risk breaking FedEx and UPS, forcing you to re-test the entire system. OCP prevents this regression.

---

## Bad vs. Good Code (The Interview Standard)

Interviewer expectations hinge on your ability to refactor code on a whiteboard. Here is a classic example of how to present it.

### ❌ The Bad Way: Violating OCP (The `if/else` Trap)

Look at this notification system. If we want to add SMS or WhatsApp notifications, we have to modify this existing class.

```java
// VIOLATION: Every new notification type forces us to modify this class.
public class NotificationService {
    public void sendNotification(String type, String message) {
        if (type.equals("Email")) {
            // Logic to send email
            System.out.println("Sending Email: " + message);
        } else if (type.equals("SMS")) {
            // Logic to send SMS
            System.out.println("Sending SMS: " + message);
        }
    }
}
```

###  The Good Way: Adhering to OCP (Abstraction)

To fix this, we introduce an interface or abstract class. New notification types will implement this interface, leaving the core engine untouched.

```java
// 1. Create an abstraction
public interface NotificationChannel {
    void send(String message);
}

// 2. Open for extension: Add new channels as separate classes
public class EmailChannel implements NotificationChannel {
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

public class SMSChannel implements NotificationChannel {
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

// 3. Closed for modification: This class never changes when new channels are added
public class NotificationProcessor {
    public void process(NotificationChannel channel, String message) {
        channel.send(message);
    }
}
```

---

## Common Ways to Achieve OCP

When designing systems, you generally use three tools to achieve OCP:

1. **Inheritance / Polymorphism:** Overriding base behaviors in subclasses.
2. **Interfaces / Strategy Pattern:** Swapping out algorithms or behaviors at runtime (like the notification example above).
3. **Dependency Injection (DI):** Passing the required behavior into the class rather than letting the class instantiate it directly.

---

## 🎯 Top Interview Follow-Up Questions (and How to Answer)

If you use OCP in a system design interview, expect the interviewer to grill you with these follow-ups:

### 1. "If we never modify code, how do we fix bugs?"
**How to answer:** OCP applies to *adding features and changing requirements*, not bug fixes. If existing code has a bug, you must modify it to fix the bug. OCP ensures that when a *new* requirement comes in, you don't introduce *new* bugs into stable code.

### 2. "Does OCP mean I should use interfaces for every single class I write?"
**How to answer:** No, that is "over-engineering." Introduce abstractions only where you realistically expect variation or extension. If a component is simple and highly unlikely to change, writing interfaces adds unnecessary boilerplate and cognitive load.

### 3. "How does OCP relate to design patterns?"
**How to answer:** Many classic GoF (Gang of Four) design patterns are essentially blueprints for achieving OCP. For example:
* **Strategy Pattern:** Allows switching algorithms cleanly.
* **Factory Method / Abstract Factory:** Closes the business logic from creation details.
* **Decorator Pattern:** Adds behavior to objects dynamically without modifying the original class.

### 4. "Can you 100% close a system against any modification?"
**How to answer:** No, 100% closure is a myth. A system can only be closed against *anticipated* vectors of change. If a completely unpredictable requirement drops, you may have to refactor existing abstractions to accommodate it. The goal is strategic closure, not absolute closure.

open_closed_principle_guide.md
Displaying open_closed_principle_guide.md.
