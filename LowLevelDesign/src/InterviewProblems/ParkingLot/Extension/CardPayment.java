package InterviewProblems.ParkingLot.Extension;

public class CardPayment implements PaymentMethod{

    @Override
    public void Pay(double amount) {
        System.out.println("Paid Rs. " + amount + " via Card");
    }
}
