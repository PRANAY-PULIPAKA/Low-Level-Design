package InterviewProblems.CarRentalSystem;


public class DefaultPricingStrategy implements PricingStrategy {
    @Override
    public double CalculatePrice(VehicleType type, int days) {
        double rateDaily;
        switch (type){
            case SUV -> rateDaily = 3000;
            case SEDAN -> rateDaily = 2000;
            default -> rateDaily = 1500;
        }

        return rateDaily * days;

    }
}
