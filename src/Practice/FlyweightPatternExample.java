package Practice;

import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;
import java.util.Map;

class Circle {
    //Extrinsic
    private int x;
    private int y;

    // let's say common and intrinsic
    //private String color;
    //private int radius;
    private CircleType circleType;

    public Circle(int x, int y, String color, int radius) {
        this.x = x;
        this.y = y;
        circleType = CircleFactory.getCircleFactory(color, radius);
    }

    public void draw() {
        System.out.println("Drawing circle of radius " + circleType.getRadius() + " with color " + circleType.getColor());
    }

}


// flyweight class
class CircleType {

    private String color;
    private int radius;

    public CircleType(String color, int radius) {
        this.color = color;
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public int getRadius() {
        return radius;
    }
}


class CircleFactory {

    private static final Map<String, CircleType> circleTypes = new HashMap<>();

    public static CircleType getCircleFactory(String color, int radius) {
        String circleTypeKey = color + "-" + radius;
        if (circleTypes.containsKey(circleTypeKey)) {
            return circleTypes.get(circleTypeKey);
        }
        circleTypes.put(circleTypeKey, new CircleType(color, radius));
        return circleTypes.get(circleTypeKey);
    }
}


public class FlyweightPatternExample {
    public static void main(String[] args) {
        Circle circle1 = new Circle(1, 1, "red", 1);
        Circle circle2 = new Circle(2, 2, "green", 1);
        Circle circle3 = new Circle(3, 3, "red", 1);
    }
}
