package Behaviroural_Design_Pattern.Mediator_Pattern;

//trying to create a chat room
class User{
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sendMessage(String message,User receiver) {
        System.out.println(this.name + " sending message to: " + receiver.getName() +" -> "+message);
    }
}

public class WithoutMediatorPattern {
    public static void main(String[] args) {
        User user1 = new User("Rakesh");
        User user2 = new User("Roshan");
        User user3 = new User("Rohan");
        User user4 = new User("Pradeep");
        User user5 = new User("Victor");

        //problem: =>
        //User5 i.e., Victor have to send the same message again and again to every individual
        // also User5 is directly interacting with other individuals
        //each object has to know about another object which is tightly coupled
        user5.sendMessage("Hello All", user1);
        user5.sendMessage("Hello All", user2);
        user5.sendMessage("Hello All", user3);
        user5.sendMessage("Hello All", user4);

    }
}
