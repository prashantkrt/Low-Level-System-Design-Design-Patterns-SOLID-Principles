package Structural_Design_Pattern.Flyweight_Pattern;

import java.util.HashMap;
import java.util.Map;

class Circle{
    private CircleType type; // Intrinsic state (shared)

    private int radius;

    public Circle(String color, int radius) {
        this.radius = radius;
        this.type = CircleFactory.getCircleType(color);
    }
    public void draw(int x, int y) {
        System.out.println("Drawing a " + type.getColor()+ " circle at (" + x + ", " + y + ")");
    }
}

//common
class CircleType{
    private String color;

    public CircleType(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }
}

//factory
class CircleFactory{
    private static final Map<String, CircleType> circleTypes = new HashMap<>();

    public static CircleType getCircleType(String color) {
        if (circleTypes.containsKey(color)) {
            return circleTypes.get(color);
        }
        CircleType circleType = new CircleType(color);
        circleTypes.put(color, circleType);
        return circleType;
    }
}

public class FlyweightPatternExample {
    public static void main(String[] args) {

      Circle circle1 = new Circle("red", 10);
      circle1.draw(10, 10);
      Circle circle2 = new Circle("green", 20);
    }
}
