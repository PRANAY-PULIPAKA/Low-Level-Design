package InterviewProblems.CarRentalSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarInventory {
    private final Map<Location, List<Car>> carsByLocation = new HashMap<>();

    public void addCar(Location location, Car car){
        carsByLocation.computeIfAbsent(location, k -> new ArrayList<>()).add(car);
    }

    public List<Car> getAvailableCars(Location location){
        List<Car> cars = carsByLocation.getOrDefault(location, List.of());
        List<Car> available = new ArrayList<>();

        for(Car car: cars){
            if(car.isAvailable()){
                available.add(car);
            }
        }
        return  available;
    }
}
