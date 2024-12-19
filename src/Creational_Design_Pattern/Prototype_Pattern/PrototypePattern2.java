package Creational_Design_Pattern.Prototype_Pattern;
interface Prototype2 {
    Prototype2 clone();
}

class Circle implements Prototype2 {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public Prototype2 clone() {
        return new Circle(this.radius);
    }

    @Override
    public String toString() {
        return "Circle with radius: " + radius;
    }
}

class Rectangle implements Prototype2 {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public Prototype2 clone() {
        return new Rectangle(this.width, this.height);
    }

    @Override
    public String toString() {
        return "Rectangle with width: " + width + ", height: " + height;
    }
}

public class PrototypePattern2 {
    public static void main(String[] args) {
        // Create original objects
        Circle originalCircle = new Circle(10);
        Rectangle originalRectangle = new Rectangle(20, 30);

        // Clone objects
        Circle clonedCircle = (Circle) originalCircle.clone();
        Rectangle clonedRectangle = (Rectangle) originalRectangle.clone();

        // Display original and cloned objects
        System.out.println("Original Circle: " + originalCircle);
        System.out.println("Cloned Circle: " + clonedCircle);

        System.out.println("Original Rectangle: " + originalRectangle);
        System.out.println("Cloned Rectangle: " + clonedRectangle);

    }
}
