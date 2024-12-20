package Structural_Design_Pattern.Proxy_Pattern;

interface Image {
    void display();
}

class RealImage implements Image {

    private final String filename;

    RealImage(String filename) {
        this.filename = filename;
        loadTheImageFromDisk(); // expensive operation, eager loading
    }

    private void loadTheImageFromDisk() {
        System.out.println("Loading image from disk " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying image " + filename);
    }
}

public class WithoutProxyPattern {
    public static void main(String[] args) {
        RealImage realImage = new RealImage("image.jpeg"); // will load the image even not required

        //my goal is to load only when we want it to display else don't load it
        realImage.display();

        // we need a proxy pattern to lazy loading
        // Also while creating a multiple object of real image multiple times object will be created
        // No Caching happening so a proxy pattern can help for caching
    }
}
