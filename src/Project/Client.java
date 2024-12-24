package Project;

public class Client {
    public static void main(String[] args) {

        RideSharingApplicationService service = new RideSharingApplicationService();
        service.addDriver(new Driver("Raju",new Location(10,20),new Vehicle("ABC 1112","Car")));
        service.addDriver(new Driver("Rajesh",new Location(15,26),new Vehicle("MRX 312","Car")));
        service.addDriver(new Driver("Brijesh",new Location(15,26),new Vehicle("BMW 312","Car")));
        service.addDriver(new Driver("Chantu Kumar",new Location(25,26),new Vehicle("KMW 371","Bike")));
        service.addDriver(new Driver("Ravi",new Location(10,11),new Vehicle("BGV 071","Bike")));

        service.bookRide(new Passenger("Montu",new Location(10,10)),5);

        service.bookRide(new Passenger("Suresh",new Location(20,20)),15);
    }
}
