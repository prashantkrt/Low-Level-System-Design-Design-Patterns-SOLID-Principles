package Project;

public class RideSharingApplicationClient {
    public static void main(String[] args) {

        RideSharingApplicationService service = new RideSharingApplicationService();

        service.addDriver(new Driver("Raju", new Location(10, 20), new Vehicle("ABC 1112", "Car"),Status.AVAILABLE));
        service.addDriver(new Driver("Rajesh", new Location(15, 26), new Vehicle("MRX 312", "Car"),Status.AVAILABLE));
        service.addDriver(new Driver("Brijesh", new Location(15, 26), new Vehicle("BMW 312", "Car"),Status.AVAILABLE));
        service.addDriver(new Driver("Chantu Kumar", new Location(25, 26), new Vehicle("KMW 371", "Bike"),Status.AVAILABLE));
        service.addDriver(new Driver("Ravi", new Location(10, 11), new Vehicle("BGV 071", "Bike"),Status.AVAILABLE));

        service.addPassenger(new Passenger("Montu", new Location(10, 10)));
        service.addPassenger(new Passenger("Rajesh", new Location(15, 26)));
        service.addPassenger(new Passenger("Suresh", new Location(20, 20)));


        service.bookRide(new Passenger("Montu", new Location(10, 10)), 5);
        service.bookRide(new Passenger("Rajesh", new Location(15, 26)), 25);
        service.bookRide(new Passenger("Suresh", new Location(20, 20)), 15);

        service.getDrivers().forEach(x-> System.out.println(x.getName()+" "+x.getStatus()));
    }
}
