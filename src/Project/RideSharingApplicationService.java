package Project;

import java.util.ArrayList;
import java.util.List;

public class RideSharingApplicationService {

    // Matching service
    // Used for differentiating between drivers and passengers
    private final List<Driver> drivers;
    private final List<Passenger> passengers;

    public RideSharingApplicationService() {
        drivers = new ArrayList<>();
        passengers = new ArrayList<>();
    }

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    //booking the ride
    public void bookRide(Passenger passenger,double distance) {
        if(drivers.isEmpty()){
            System.out.println("No ride is available");
            return;
        }
        for(Driver driver : drivers){

        }


    }
}
