package Creational_Design_Pattern.Factory_Pattern;

interface Transportation {
    public void deliver();
}

class Ship implements Transportation {
    @Override
    public void deliver() {
        System.out.println("delivery by ship");
    }
}

class Aeroplane implements Transportation {

    @Override
    public void deliver() {
        System.out.println("deliver by aeroplane");
    }
}

class CargoTruck implements Transportation {
    @Override
    public void deliver() {
        System.out.println("deliver by cargo truck");
    }
}

//Factory class responsible for creation of an object based on the type
class TransportFactory {
    public static Transportation getTransportation(String type) {
        if (type.equalsIgnoreCase("Aeroplane")) {
            return new Aeroplane();
        } else if (type.equalsIgnoreCase("CargoTruck")) {
            return new CargoTruck();
        } else if (type.equalsIgnoreCase("Ship")) {
            return new Ship();
        } else {
            throw new IllegalArgumentException("No such transportation");
        }
    }
}

// better we can go with this way too!!
//enum TransportationType {
//    AEROPLANE, CARGO_TRUCK, SHIP
//}
//
//class TransportFactory {
//    public static Transportation getTransportation(TransportationType type) {
//        switch (type) {
//            case AEROPLANE:
//                return new Aeroplane();
//            case CARGO_TRUCK:
//                return new CargoTruck();
//            case SHIP:
//                return new Ship();
//            default:
//                throw new IllegalArgumentException("No such transportation");
//        }
//    }
//}

// client code not creating the object
// at the runtime we can change the type without modifying the client, here we are open/closed following
public class FactoryPattern {
    public static void main(String[] args) {
        Transportation transportation = TransportFactory.getTransportation("ship");
        transportation.deliver();
        transportation = TransportFactory.getTransportation("aeroplane");
        transportation.deliver();
        transportation = TransportFactory.getTransportation("cargoTruck");
        transportation.deliver();
    }
}
