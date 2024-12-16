package Behaviroural_Design_Pattern.Command_Pattern;

import OOPs.PaymentMethod;

//Receiver
class Light {

    public void on() {
        System.out.println("Light on");
    }

    public void off() {
        System.out.println("Light off");
    }
}


//command
interface LightCommand {
    void execute();
}


//commands
class LightOnCommand implements LightCommand {

    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}

class LightOffCommand implements LightCommand {

    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}

//Invoker
//remote
class RemoteControl {

    private LightCommand command;

    public RemoteControl(LightCommand command) {
        this.command = command;
    }

    public void onClick() {
        command.execute();
    }

}

public class CommandPattern2 {
    public static void main(String[] args) {
        Light light = new Light();
        RemoteControl control = new RemoteControl(new LightOnCommand(light));
        control.onClick();
        control = new RemoteControl(new LightOffCommand(light));
        control.onClick();
    }
}
