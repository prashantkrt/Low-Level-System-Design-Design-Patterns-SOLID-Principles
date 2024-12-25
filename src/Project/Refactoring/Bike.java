package Project.Refactoring;

public class Bike extends Vehicle {
    public Bike(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    public double getFarePerKM() {
        return 10.0;
    }
}
