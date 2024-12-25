package Project.Refactoring;

// Acts as a mediator between Ride, Driver and Passenger
public class Ride {

    private final Driver driver;
    private final Passenger passenger;
    private final double distance;
    private final FareStrategy strategy;
    private double fare;
    private RideStatus rideStatus;

    public Ride(Driver driver, Passenger passenger, double distance, FareStrategy strategy) {
        this.driver = driver;
        this.passenger = passenger;
        this.distance = distance;
        this.strategy = strategy;
        this.rideStatus = RideStatus.PENDING;
    }

    public void calculateFare() {
        this.fare = strategy.calculateFare(driver.getVehicle(), distance);
    }

    public void updateRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
        notifyRideStatus();
    }

    public void notifyRideStatus() {
        driver.notify("Your ride status:" + rideStatus);
        passenger.notify("your ride status: " + rideStatus);
    }

    public double getFare() {
        return fare;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }
}
