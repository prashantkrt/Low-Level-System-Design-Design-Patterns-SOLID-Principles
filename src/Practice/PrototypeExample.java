package Practice;

class Prototype implements Cloneable {

    private String name;
    private int age;

    Prototype(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public Prototype clone() {
        try {
            return (Prototype) super.clone(); // jis bhi current object se yeh call hoga parent wala clone() jvm usi ka copy bana ke return kar dega
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Prototype{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class PrototypeExample {
    public static void main(String[] args) {
        Prototype prototype = new Prototype("Practice", 18);
        System.out.println(prototype);
        Prototype clone = prototype.clone();
        System.out.println(clone);
    }
}
