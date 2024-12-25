package Project.Refactoring;

public class Auto extends Vehicle{
    public Auto(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    public double getFarePerKM() {
        return 12.0;
    }
}
