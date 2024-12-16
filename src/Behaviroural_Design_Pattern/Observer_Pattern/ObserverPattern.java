package Behaviroural_Design_Pattern.Observer_Pattern;

import java.util.ArrayList;
import java.util.List;

interface Observer{
    void update(float temperature);
}

class Mobile implements Observer{

    @Override
    public void update(float temperature) {
        System.out.println("Message received on mobile for current temperature => "+temperature);
    }
}

class Radio implements Observer{

    @Override
    public void update(float temperature) {
        System.out.println("Message received on radio for current temperature => "+temperature);
    }
}

interface Subject{
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

class WeatherReporter implements Subject{

    private float temperature;
    private List<Observer> observerList;

    public WeatherReporter(){
        observerList = new ArrayList<>();
    }

    public void setTemperature(float temperature){
        this.temperature = temperature;
    }

    public float getTemperature(){
        return temperature;
    }


    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update(temperature);
        }
    }
}
public class ObserverPattern {
    public static void main(String[] args) {

     //publisher
     WeatherReporter weatherReporter = new WeatherReporter();
     weatherReporter.setTemperature(27.5f);


     //Multiple consumers Mobile, Radio and many more can be added
     weatherReporter.registerObserver(new Mobile());
     weatherReporter.registerObserver(new Radio());

     //notifying
     weatherReporter.notifyObservers();
    }
}
