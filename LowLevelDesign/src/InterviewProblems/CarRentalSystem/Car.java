package InterviewProblems.CarRentalSystem;

public class Car {

    private final String carId;

    private final  VehicleType type;

    private boolean isAvailable;


    public Car(String carId, VehicleType type, boolean isAvailable){
        this.carId = carId;
        this.type = type;
        this.isAvailable = true;
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    public void markBooked(){
        isAvailable = false;
    }

    public void markAvailable(){
        isAvailable = true;
    }

    public VehicleType getType(){
        return  type;
    }


}
