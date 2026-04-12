package InterviewProblems.CarRentalSystem;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class CarRentalService {

    private final CarInventory inventory;

    private final PricingStrategy pricingStrategy;

    private final  PaymentService paymentService;

    public CarRentalService(CarInventory inventory, PricingStrategy pricingStrategy, PaymentService paymentService){
        this.inventory = inventory;
        this.pricingStrategy = pricingStrategy;
        this.paymentService = paymentService;
    }

    public Booking bookCar(User user, Location location, VehicleType type, LocalDate start, LocalDate end){

        for(Car car : inventory.getAvailableCars(location)){
            if(car.getType() == type){

                int days = (int) ChronoUnit.DAYS.between(start, end);
                double price = pricingStrategy.CalculatePrice(type, days);

                if(paymentService.processPayment(price)){
                    car.markBooked();
                    return new Booking( UUID.randomUUID().toString(),
                            user, car, start, end, price);
                }

            }
        }

        throw  new RuntimeException("No cars available");
    }
}
