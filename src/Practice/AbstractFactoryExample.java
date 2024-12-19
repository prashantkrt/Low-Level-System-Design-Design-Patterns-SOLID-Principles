package Practice;



interface Vehicle {
    void manufacture();
}

//concrete class of Vehicles
//car
class SUV implements Vehicle {

    @Override
    public void manufacture() {
        System.out.println("SUV manufacture");
    }
}

class Sedan implements Vehicle {
    @Override
    public void manufacture() {
        System.out.println("Sedan manufacture");
    }
}

//bike
class SportsBike implements Vehicle {
    @Override
    public void manufacture() {
        System.out.println("Bike manufacture");
    }
}

class CruiserBike implements Vehicle {
    @Override
    public void manufacture() {
        System.out.println("Bike manufacture");
    }
}

//truck
class PickupTruck implements Vehicle {
    @Override
    public void manufacture() {
        System.out.println("Truck manufacture");
    }
}

class HeavyTruck implements Vehicle {
    @Override
    public void manufacture() {
        System.out.println("Truck manufacture");
    }
}

//abstract factory
interface VehicleFactory {
    Vehicle createVehicle(String type);
}

class CarFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle(String type) {
        return switch (type.toLowerCase()) {
            case "suv" -> new SUV();
            case "sedan" -> new Sedan();
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }
}

class BikeFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle(String type) {
        return switch (type.toLowerCase()){
            case "sports" -> new SportsBike();
            case "cruiser" -> new CruiserBike();
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }
}

class TruckFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle(String type) {
        return switch (type.toLowerCase()){
            case "pickup" -> new PickupTruck();
            case "heavy" -> new HeavyTruck();
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }
}

class VehicleMasterFactory {
    public static VehicleFactory createVehicle(String type) {
       return switch (type.toLowerCase()){
           case "car" -> new CarFactory();
           case "bike" -> new BikeFactory();
           case "truck" -> new TruckFactory();
           default -> throw new IllegalStateException("Unexpected value: " + type.toLowerCase());
       };
    }
}


public class AbstractFactoryExample {
    public static void main(String[] args) {
        VehicleFactory vehicleFactory = VehicleMasterFactory.createVehicle("car");
        Vehicle vehicle = vehicleFactory.createVehicle("suv");
        vehicle.manufacture();
    }
}
