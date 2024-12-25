package Project.Refactoring;

//Payment Strategies
public interface FareStrategy {
    double calculateFare(Vehicle vehicle, double distance);
}

//Standard
class StandardFareStrategy implements FareStrategy {

    @Override
    public double calculateFare(Vehicle vehicle, double distance) {
        return vehicle.getFarePerKM() * distance;
    }
}

//Shared
class SharedFareStrategy implements FareStrategy {
    @Override
    public double calculateFare(Vehicle vehicle, double distance) {
        return vehicle.getFarePerKM() * distance * .40;
    }
}

//Luxury
class LuxuryFareStrategy implements FareStrategy {
    @Override
    public double calculateFare(Vehicle vehicle, double distance) {
        return vehicle.getFarePerKM() * distance * 1.40;
    }
}
