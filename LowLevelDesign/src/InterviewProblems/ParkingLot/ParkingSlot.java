package InterviewProblems.ParkingLot;

public class ParkingSlot {
    private final int slotId;
    private final VehicleType allowedType;

    private Vehicle parkedVehicle;

    public ParkingSlot(int slotId, VehicleType allowedType){
      this.slotId = slotId;
      this.allowedType = allowedType;
    }

    public boolean isFree(){
        return parkedVehicle == null;
    }

    public boolean canFit(Vehicle vehicle){
        return allowedType == vehicle.getType();
    }

    public void park(Vehicle vehicle){
        this.parkedVehicle = vehicle;
    }

    public void unPark(){
        this.parkedVehicle = null;
    }

//    public long unparkAndGetDurationInHours() {
//        long exitTime = System.currentTimeMillis();
//        parkedVehicle = null;
//
//        long durationMs = exitTime - entryTime;
//        return Math.max(1, durationMs / (1000 * 60 * 60));
//    }

    public int getSlotId(){
        return  slotId;
    }

}
