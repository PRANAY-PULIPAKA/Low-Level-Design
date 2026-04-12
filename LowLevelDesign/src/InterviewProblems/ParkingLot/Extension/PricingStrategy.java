package InterviewProblems.ParkingLot.Extension;

import InterviewProblems.ParkingLot.VehicleType;

public interface PricingStrategy {
    double  calculateFee(VehicleType type, long durationInHours);
}
