package Project.Refactoring;

public class Passenger extends User{
    public Passenger(String name, Location location) {
        super(name, location);
    }

    @Override
    public void notify(String message) {
        System.out.println("Passenger => "+this.getName()+" -> "+message);
    }
}
