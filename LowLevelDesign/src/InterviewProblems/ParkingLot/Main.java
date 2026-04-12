package InterviewProblems.ParkingLot;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(3);

        Vehicle vehicle1 = new Car("TS 02 BC 5253");
        Vehicle vehicle2 = new Car("TS 02 BC 1236");

        parkingLot.parkVehicle(vehicle1);
        parkingLot.parkVehicle(vehicle2);

        parkingLot.unparkVehicle(1);
    }
}
