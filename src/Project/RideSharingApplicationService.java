package Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Breaking SRP
//managing passengers
//managing driver
//booking , fare calculation , distance calculations
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
    public void bookRide(Passenger passenger, double distance) {

        if (drivers.isEmpty()) {
            System.out.println("No ride is available");
            return;
        }

        Driver assignedDriver = null;
        double minDistance = Double.MAX_VALUE;
        for (Driver driver : drivers) {
            if(driver.getStatus() == Status.AVAILABLE) {
                double currentDistance = calculateDistance(passenger.getLocation(), driver.getLocation());
                if (currentDistance < minDistance) {
                    minDistance = currentDistance;
                    assignedDriver = driver;
                }
            }
        }
        if (assignedDriver == null) {
            System.out.println("No ride is available");
            return;
        }
        assignedDriver.setStatus(Status.BOOKED);
        double expectedFare = calculateFare(assignedDriver.getVehicle(), distance);

        System.out.println("Ride is available");
        System.out.println("Booked driver: " + assignedDriver.getName() + " " + "vehicle number " + assignedDriver.getVehicle().getVehicleNumber() + " distance: " + distance + " expectedFare: " + expectedFare);
        System.out.println("Driver is on your way");
    }

    private double calculateDistance(Location passengerLocation, Location driverLocation) {
        //Euclidean formula
        double distanceLatitude = passengerLocation.getLatitude() - driverLocation.getLatitude();
        double distanceLongitude = passengerLocation.getLongitude() - driverLocation.getLongitude();
        return Math.sqrt(Math.pow(distanceLatitude, 2) + Math.pow(distanceLongitude, 2));
    }

    //violates OCP as if I need to add a new type of vehicle, then we have to make code change
    private double calculateFare(Vehicle vehicle, double distance) {
        return switch (vehicle.getVehicleType().toLowerCase()) {
            case "car" -> distance * 25;
            case "auto" -> distance * 12;
            case "bike" -> distance * 10;
            default -> distance * 8;
        };
    }
}
