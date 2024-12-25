package Project.Refactoring;

public class Car extends Vehicle {
    public Car(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    public double getFarePerKM() {
        return 25.0;
    }
}
