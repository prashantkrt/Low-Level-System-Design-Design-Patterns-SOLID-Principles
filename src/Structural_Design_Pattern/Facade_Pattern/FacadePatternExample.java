package Structural_Design_Pattern.Facade_Pattern;

// Subsystem 1: DVD Player
class DVDPlayer {
    public void turnOn() {
        System.out.println("DVD Player is ON.");
    }

    public void playMovie(String movie) {
        System.out.println("Playing movie: " + movie);
    }

    public void turnOff() {
        System.out.println("DVD Player is OFF.");
    }
}

// Subsystem 2: Sound System
class SoundSystem {
    public void setVolume(int level) {
        System.out.println("Sound system volume set to " + level);
    }
}

// Subsystem 3: Projector
class Projector {
    public void turnOn() {
        System.out.println("Projector is ON.");
    }

    public void turnOff() {
        System.out.println("Projector is OFF.");
    }
}

// Facade: Home Theater
class HomeTheaterFacade {
    private DVDPlayer dvdPlayer;
    private SoundSystem soundSystem;
    private Projector projector;

    public HomeTheaterFacade(DVDPlayer dvdPlayer, SoundSystem soundSystem, Projector projector) {
        this.dvdPlayer = dvdPlayer;
        this.soundSystem = soundSystem;
        this.projector = projector;
    }

    public void watchMovie(String movie) {
        System.out.println("Preparing to watch a movie...");
        projector.turnOn();
        soundSystem.setVolume(10);
        dvdPlayer.turnOn();
        dvdPlayer.playMovie(movie);
        System.out.println("Enjoy the movie!");
    }

    public void stopMovie() {
        System.out.println("Stopping the movie...");
        dvdPlayer.turnOff();
        projector.turnOff();
        System.out.println("Movie stopped.");
    }
}

public class FacadePatternExample {
    public static void main(String[] args) {
        // Create instances of subsystems
        DVDPlayer dvdPlayer = new DVDPlayer();
        SoundSystem soundSystem = new SoundSystem();
        Projector projector = new Projector();

        // Create the Facade
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvdPlayer, soundSystem, projector);

        // Use the simplified interface
        homeTheater.watchMovie("Inception");
        homeTheater.stopMovie();

    }
}
