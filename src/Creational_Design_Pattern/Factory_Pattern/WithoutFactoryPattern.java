package Creational_Design_Pattern.Factory_Pattern;

interface Transport {
    public void deliver();
}

class Car implements Transport {

    @Override
    public void deliver() {
        System.out.println("Delivery by car");
    }
}

class Bike implements Transport {

    @Override
    public void deliver() {
        System.out.println("Deliver by bike");
    }
}

class Train implements Transport {
    @Override
    public void deliver() {
        System.out.println("Deliver by train");
    }
}

// client is tightly coupled with the object
// we should have other class for object creation rather than client itself
public class WithoutFactoryPattern {
    public static void main(String[] args) {
        //Direct object creation
        Transport car = new Car();
        Transport bike = new Bike();

        // kind of violation of open and closed since we have to modify the client code
        // wanted to add a train object
        Transport train = new Train();
    }
}
