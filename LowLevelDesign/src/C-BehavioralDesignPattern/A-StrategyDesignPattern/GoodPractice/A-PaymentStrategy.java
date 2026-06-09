package BehavioralDesignPattern.StrategyDesignPattern.GoodPractice;

public interface PaymentStrategy {
    void processPayment();
}
class CreditCardPayment implements PaymentStrategy {
    public void processPayment() {
        System.out.println("Processing credit card payment...");
    }
}

// Concrete strategy for PayPal payment
class PayPalPayment implements PaymentStrategy {
    public void processPayment() {
        System.out.println("Processing PayPal payment...");
    }
}

// Concrete strategy for crypto payment
class CryptoPayment implements PaymentStrategy {
    public void processPayment() {
        System.out.println("Processing crypto payment...");
    }
}
// Concrete strategy for Stripe payment
class StripePayment implements PaymentStrategy {
    public void processPayment() {
        System.out.println("Processing Stripe payment...");
    }
}
