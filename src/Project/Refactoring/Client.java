package Project.Refactoring;

public class Client {
    public static void main(String[] args) {
        Location location1 = new Location(10,20);
        Location location2 = new Location(20,30);
        Location location3 = new Location(10,10);
        Location location4 = new Location(40,50);
        Location location5 = new Location(10,12);

        Vehicle vehicle1 = new Car("ABC 123");
        Vehicle vehicle2 = new Car("WZA 223");
        Vehicle vehicle3 = new Bike("SSA 123");
        Vehicle vehicle4 = new Auto("BBSE 123");
        Vehicle vehicle5 = new Bike("WZA 203");

        Driver driver1 = new Driver("Sam",location1,vehicle1);
        Driver driver2 = new Driver("Rocky",location2,vehicle2);
        Driver driver3 = new Driver("Shantu",location3,vehicle3);
        Driver driver4 = new Driver("Vicky",location4,vehicle4);
        Driver driver5 = new Driver("Sammy",location5,vehicle5);

        RideMatchingSystem rideMatchingSystem = new RideMatchingSystem();
        rideMatchingSystem.addDriver(driver1);
        rideMatchingSystem.addDriver(driver2);
        rideMatchingSystem.addDriver(driver3);
        rideMatchingSystem.addDriver(driver4);
        rideMatchingSystem.addDriver(driver5);

        Location location6 = new Location(15,22);
        Location location7 = new Location(25,32);

        Passenger passenger1 = new Passenger("Aman",location6);
        Passenger passenger2 = new Passenger("Bhinod",location7);

        rideMatchingSystem.requestRide(passenger1,25,new StandardFareStrategy());
        System.out.println("=================================");
        rideMatchingSystem.requestRide(passenger2,35,new StandardFareStrategy());
    }
}
