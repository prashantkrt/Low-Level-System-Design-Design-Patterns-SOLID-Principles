package Structural_Design_Pattern.Flyweight_Pattern;

//Extrinsic Property -> unique and not shared
//Intrinsic Property -> Common and shared

import java.util.HashMap;
import java.util.Map;

//Ammo or Bullet class
class Ammo {

    private AmmoType ammoType; // all the intrinsic property

    //Extrinsic Property
    private int x, y;

    private int velocity;

    public Ammo(String color, int x, int y, int velocity) {
        this.ammoType = AmmoTypeFactory.getAmmoType(color); // re-using
        this.x = x;
        this.y = y;
        this.velocity = velocity;
        System.out.println("Creating the "+color+" bullet with the "+x+" "+y+" "+velocity);
    }

    public void display() {
        System.out.println("Bullet at x: " + this.x + " y: " + this.y + "with moving velocity: " + this.velocity);
    }
}


// create a Flyweight class wil all the common shared properties
//Flyweight class
class AmmoType {

    private String color;

    public AmmoType(String color) {
        this.color = color;
    }
}

//Flyweight class factory.
//Factory class for storing the data
class AmmoTypeFactory {

    private static final Map<String, AmmoType> ammoTypes = new HashMap<>();

    public static AmmoType getAmmoType(String color) {
        if (!ammoTypes.containsKey(color)) {
            ammoTypes.put(color, new AmmoType(color));
            return ammoTypes.get(color);
        }
        return ammoTypes.get(color);
    }
}


//client
public class FlyweightPattern {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
         Ammo ammo = new Ammo("red", i*10, i*20, i*1000);
        }

        for (int i = 0; i < 10; i++) {
            Ammo ammo = new Ammo("black", i*5, i*8, i*2000);
        }
    }
}
