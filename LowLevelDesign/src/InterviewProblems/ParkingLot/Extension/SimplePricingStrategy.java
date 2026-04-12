package InterviewProblems.ParkingLot.Extension;

import InterviewProblems.ParkingLot.VehicleType;

public class SimplePricingStrategy implements PricingStrategy{
    @Override
    public double calculateFee(VehicleType type, long durationInHours) {

        double ratePerHour;

        switch (type) {

            case BIKE:
                ratePerHour = 10;
                break;
            case CAR:
                ratePerHour = 20;
                break;
            case TRUCK:
                ratePerHour = 30;
                break;
            default:
                throw  new IllegalArgumentException("Invalid vehicle type");
        }

        return  ratePerHour * durationInHours;
    }
}
