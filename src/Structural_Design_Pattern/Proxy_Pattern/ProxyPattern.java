package Structural_Design_Pattern.Proxy_Pattern;

interface Images {
    void display();
}

class RealImages implements Images {

    private String filename;

    public RealImages(String filename) {
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

class ProxyImage implements Images {

    private String filename;

    private RealImages realImages;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImages == null) {
            realImages = new RealImages(filename); // lazy loaded and cached
        }
        realImages.display();
    }
}

public class ProxyPattern {
    public static void main(String[] args) {
       Images images = new ProxyImage("realImages.txt");
       images.display();
    }
}
