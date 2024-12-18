package Behaviroural_Design_Pattern.Mediator_Pattern;

import java.util.ArrayList;
import java.util.List;

//chat system
interface ChatMediator {
    void sendMessage(String message, Person person);

    void addPerson(Person person);
}

//chatroom is the concrete impl for mediator
class Chatroom implements ChatMediator {

    private List<Person> persons = new ArrayList<>();

    @Override
    public void sendMessage(String message, Person sender) {
        for (Person receiver : persons) {
            if (!(sender.equals(receiver))) {
                receiver.receiveMessage(message, sender);
            }
        }
    }

    @Override
    public void addPerson(Person person) {
        persons.add(person);
    }
}

class Person {

    private String name;
    private ChatMediator chatMediator;

    public Person(String name, ChatMediator chatMediator) {
        this.name = name;
        this.chatMediator = chatMediator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sendMessage(String message) {
        chatMediator.sendMessage(message, this);
    }

    public void receiveMessage(String message, Person sender) {
        System.out.println(this.name + " receiving message from " + sender.getName());
    }
}


public class MediatorPattern {
    public static void main(String[] args) {

        ChatMediator chatroom = new Chatroom();

        Person john = new Person("John", chatroom);
        Person jane = new Person("Jane", chatroom);
        Person jack = new Person("Jack", chatroom);
        Person tom = new Person("Tom", chatroom);
        Person alice = new Person("Alice", chatroom);

        chatroom.addPerson(john);
        chatroom.addPerson(jane);
        chatroom.addPerson(jack);
        chatroom.addPerson(tom);
        chatroom.addPerson(alice);

        john.sendMessage("Hello All");
    }
}
