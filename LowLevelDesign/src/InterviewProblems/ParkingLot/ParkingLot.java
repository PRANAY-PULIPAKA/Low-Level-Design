package InterviewProblems.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private final List<ParkingSlot> slots;

    public ParkingLot(int numberOfSlots){
        this.slots = new ArrayList<>();

        for (int i = 1; i < numberOfSlots ; i++) {
            slots.add(new ParkingSlot(i,VehicleType.CAR));
        }
    }

    public int parkVehicle(Vehicle vehicle){
        for(ParkingSlot slot : slots){
           if(slot.isFree() && slot.canFit(vehicle)){
               slot.park(vehicle);
               System.out.println("Vehicle parked at slot: " + slot.getSlotId());
               return slot.getSlotId();
           }
        }
        throw new RuntimeException("No available slot");
    }

    public void unparkVehicle(int slotId){
      ParkingSlot slot = slots.get(slotId - 1);
      slot.unPark();
        System.out.println("Slot " + slotId + " is now free");
    }

//    public void unparkVehicle(int slotId, Vehicle vehicle, PaymentMethod paymentMethod) {
//        ParkingSlot slot = slots.get(slotId - 1);
//
//        long duration = slot.unparkAndGetDurationInHours();
//        double fee = pricingStrategy.calculateFee(vehicle.getType(), duration);
//
//        paymentMethod.pay(fee);
//        System.out.println("Slot " + slotId + " is now free");

}
