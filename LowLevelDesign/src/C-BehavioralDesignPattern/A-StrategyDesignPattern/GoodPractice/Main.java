package BehavioralDesignPattern.StrategyDesignPattern.GoodPractice;

public class Main {
    public static void main(String[] args) {
        // Create strategy instances for each payment type
        PaymentStrategy creditCard = new CreditCardPayment();
        PaymentStrategy payPal = new PayPalPayment();
        PaymentStrategy crypto = new CryptoPayment();
        PaymentStrategy stripe = new StripePayment();

        PaymentProcessor processor = new PaymentProcessor(creditCard);
        processor.processPayment();

        processor.setPaymentStrategy(payPal);
        processor.processPayment();
        
        processor.setPaymentStrategy(crypto);
        processor.processPayment(); // Processing crypto payment...
        // Switch to Stripe
        processor.setPaymentStrategy(stripe);
        processor.processPayment();

    }
}
