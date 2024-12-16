package Behaviroural_Design_Pattern.Observer_Pattern;

class DisplayDevice {
    public void displayTemperature(float temperature) {
        System.out.println("Temperature " + temperature);
    }
}

class WeatherStation {

    private float temperature;
    private DisplayDevice displayDevice; // can be multiple such devices which will cause tight coupling if having more than one

    public WeatherStation(float temperature, DisplayDevice displayDevice) {
        this.temperature = temperature;
        this.displayDevice = displayDevice;
    }

    public void notifyObservers() {
        displayDevice.displayTemperature(temperature);
    }

    //getters and setters s
    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setDisplayDevice(DisplayDevice displayDevice) {
        this.displayDevice = displayDevice;
    }

    public DisplayDevice getDisplayDevice() {
        return displayDevice;
    }
}

public class WithoutObserverPattern {
    public static void main(String[] args) {

        WeatherStation weatherStation = new WeatherStation(27, new DisplayDevice());
        weatherStation.notifyObservers();

        weatherStation.setTemperature(23);
        weatherStation.notifyObservers();
    }
}
