package Behaviroural_Design_Pattern.State_Pattern;
// Problems:=>
// we have to use if else kind of conditions
// when we have to increase the mode of transportation then the conditional logic will be increasing complexity
// Open/Closed violation suppose we have added new mode in that case we have to update our calculateETA() and getDirection() methods
// code duplication
enum TransportationMode {
    WALKING, CYCLING, CAR, TRAIN, BUS, SHIP
}

class DirectionalService {

    private TransportationMode transportationMode;

    public DirectionalService(TransportationMode transportationMode) {
        this.transportationMode = transportationMode;
    }

    public void setTransportationMode(TransportationMode transportationMode) {
        this.transportationMode = transportationMode;
    }

    public TransportationMode getTransportationMode() {
        return transportationMode;
    }

    //calculate ETA Estimated time of arrival
    public int calculateETA() {
        switch (transportationMode) {
            case WALKING:
                System.out.println("Calculating ETA for WALKING");
                return 10;
            case CYCLING:
                System.out.println("Calculating ETA for CYCLING");
                return 6;
            case CAR:
                System.out.println("Calculating ETA for CAR");
                return 3;
            case TRAIN:
                System.out.println("Calculating ETA for TRAIN");
                return 5;
            case BUS:
                System.out.println("Calculating ETA for BUS");
                return 4;
            default:
                return 20;
        }
    }

    //get the directions based on the transportation modes
    public String getDirections() {
        return switch (transportationMode) {
            case WALKING -> {
                yield "Directions for walking move to north 500 meters";
            }
            case CYCLING -> {
                yield "Directions for cycling move to lane 15 200 meters and then turn right follow the same lane";
            }
            case BUS -> "Directions for bus move to street 19 bus stop";
            case TRAIN -> "Directions for train move to Town railway station";
            default -> {
                throw new IllegalStateException("Unexpected value: " + transportationMode);
            }
        };
    }
}


public class WithoutStatePattern {
    public static void main(String[] args) {
        DirectionalService service = new DirectionalService(TransportationMode.WALKING);
        int eta = service.calculateETA();
        System.out.println(eta);
        String direction = service.getDirections();
        System.out.println(direction);

        service.setTransportationMode(TransportationMode.CYCLING);
        System.out.println(service.calculateETA());
        System.out.println(service.getDirections());

    }
}
