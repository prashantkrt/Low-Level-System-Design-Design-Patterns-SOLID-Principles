package Project.Refactoring;

import java.util.ArrayList;
import java.util.List;

public class RideMatchingSystem {

    private final List<Driver> availableDrivers;

    public RideMatchingSystem() {
        this.availableDrivers = new ArrayList<>();
    }

    public void addDriver(Driver driver) {
        this.availableDrivers.add(driver);
    }

    public List<Driver> getAvailableDrivers() {
        return availableDrivers;
    }

    public void requestRide(Passenger passenger, double rideDistance, FareStrategy fareStrategy) {

        if (availableDrivers.isEmpty()) {
            passenger.notify("No available drivers found");
            return;
        }

        Driver driver = findNearestDriver(passenger.getLocation());
        availableDrivers.remove(driver);

        Ride ride = new Ride(driver, passenger, rideDistance, fareStrategy);
        ride.calculateFare();

        //notify both
        passenger.notify("Ride Scheduled with the total fare " + ride.getFare());
        driver.notify("You have the new ride request for " + ride.getFare() + " from " + passenger.getName());

        ride.updateRideStatus(RideStatus.BOOKED);
        passenger.notify("Booked your ride driver is on the way to your current location " + driver.getName() + " vehicle number " + driver.getVehicle().vehicleNumber);

        //Once the ride is finished
        ride.updateRideStatus(RideStatus.COMPLETED);
        availableDrivers.add(driver);
    }

    private Driver findNearestDriver(Location location) {
        Driver availableDriver = null;
        double minDistance = Double.MAX_VALUE;
        for (Driver driver : availableDrivers) {
            double currentDistance = location.calculateDistance(driver.getLocation());
            if (currentDistance < minDistance) {
                minDistance = currentDistance;
                availableDriver = driver;
            }
        }
        return availableDriver;
    }
}



