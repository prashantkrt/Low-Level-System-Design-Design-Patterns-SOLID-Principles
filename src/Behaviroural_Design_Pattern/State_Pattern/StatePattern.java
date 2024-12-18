package Behaviroural_Design_Pattern.State_Pattern;

//State interface for different transportation
interface TransportationState {
    int calculateETA();

    String getDirection();
}

//concrete class for each state
class Walking implements TransportationState {

    @Override
    public int calculateETA() {
        return 10;
    }

    @Override
    public String getDirection() {
        return "Directions for walking move to north 500 meters";
    }
}

class Train implements TransportationState {

    @Override
    public int calculateETA() {
        return 5;
    }

    @Override
    public String getDirection() {
        return "Directions for train move to Town railway station";
    }
}

class Cycling implements TransportationState {
    @Override
    public int calculateETA() {
        return 6;
    }

    @Override
    public String getDirection() {
        return "Directions for cycling move to lane 15, 200 meters and then turn right follow the same lane";
    }
}

class DirectionService {

    //loose coupling
    private TransportationState state;

    DirectionService(TransportationState state) {
        this.state = state;
    }

    public TransportationState getMode() {
        return state;
    }

    public void setMode(TransportationState state) {
        this.state = state;
    }

    //based on the current state, it will calculate ETA and provide the directions
    public int calculateETA() {
        return state.calculateETA();
    }

    public String getDirection() {
        return state.getDirection();
    }
}

public class StatePattern {
    public static void main(String[] args) {
        DirectionService service = new DirectionService(new Walking());
        System.out.println(service.getDirection());
        System.out.println(service.calculateETA());
    }
}
