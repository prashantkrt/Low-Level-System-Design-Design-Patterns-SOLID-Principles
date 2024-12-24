package Project;

public class Driver {
    private String name;
    private Location location;
    private Vehicle vehicle;

    public Driver(String name, Location location, Vehicle vehicle) {
        this.name = name;
        this.location = location;
        this.vehicle = vehicle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
