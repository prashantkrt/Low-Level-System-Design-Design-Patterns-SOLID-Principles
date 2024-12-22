package Structural_Design_Pattern.Flyweight_Pattern;

//Extrinsic Property => not shared and unique
//Intrinsic Property => shared and common

class Bullet{
    //common
    private String color; //Intrinsic Property

    //Unique
    private int x , y;  //Extrinsic property

    private int velocity;  //Extrinsic Property

    public Bullet(String color, int x, int y, int velocity) {
        this.color = color; // common
        this.x = x;
        this.y = y;
        this.velocity = velocity;
        System.out.println("Creating the "+color+" bullet with the "+x+" "+y+" "+velocity);
    }

    public void display() {
        System.out.println("Bullet at x: " + this.x + " y: " + this.y + "with moving velocity: " + this.velocity);
    }
}


public class WithoutFlyweightPattern {
    public static void main(String[] args) {
        Bullet bullet1 = new Bullet("black", 100, 100, 100);
        Bullet bullet2 = new Bullet("black", 200, 200, 200);
        Bullet bullet3 = new Bullet("black", 300, 300, 300);
        // let's say we have 10^5 bullets in a game in that case every time it going to store the bullet properties in memory
        bullet1.display();
        bullet2.display();
        bullet3.display();


        // let's say this
        // lot of memory consumption where every bullet stores redundant data
        // slow performance if many new bullets created

        //10 red color bullets
        for (int i = 0; i < 10; i++) {
            Bullet newBullet= new Bullet("red", i*10,i*20, 100);
        }

        //20 green color
        for (int i = 0; i < 20; i++) {
            Bullet newBullet= new Bullet("green", i*10,i*20, 100);
        }
    }
}
