package InterviewProblems.CarRentalSystem;

public interface PricingStrategy {
    double CalculatePrice(VehicleType type, int days);
}
