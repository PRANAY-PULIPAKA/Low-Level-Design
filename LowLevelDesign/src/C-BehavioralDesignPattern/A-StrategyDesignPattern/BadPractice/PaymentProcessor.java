package BehavioralDesignPattern.StrategyDesignPattern.BadPractice;

import java.sql.Struct;

public class PaymentProcessor {
    public void processPayment(String paymentMethod){

        if(paymentMethod.equals("CreditCard")){
            System.out.println("Processing Credit Card payment");
        } else if (paymentMethod.equals("Paypal")) {
            System.out.println("Processing Paypal payment");
        } else if (paymentMethod.equals("Crypto")) {
            System.out.println("Processing Crypto Payment");
        } else {
            System.out.println("Method Method is not supported");
        }
    }
}
