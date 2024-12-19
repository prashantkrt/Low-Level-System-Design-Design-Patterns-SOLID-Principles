package Creational_Design_Pattern.AbstractFactory_Pattern;

//Windows UI Components
class WindowsButton {
    public void render() {
        System.out.println("Rendering windows button");
    }
}

class WindowsScrollBar {
    public void scroll() {
        System.out.println("Scrolling windows scroll bar");
    }
}

//Mac UI Components
class MacOSButton {
    public void render() {
        System.out.println("Rendering MacOS button");
    }
}

class MacOSScrollBar {
    public void scroll() {
        System.out.println("Scrolling MacOS scroll Bar");
    }
}

//client
public class WithoutAbstractFactoryPattern {
    public static void main(String[] args) {
        //client can create an object which we should avoid
        //tight coupling
        WindowsButton windowsButton = new WindowsButton();
        windowsButton.render();
        WindowsScrollBar windowsScrollBar = new WindowsScrollBar();
        windowsScrollBar.scroll();
        //now wanted to use MacUI components then we have to modify it
        MacOSButton macOSButton = new MacOSButton();
        macOSButton.render();
        MacOSScrollBar macOSScrollBar = new MacOSScrollBar();
        macOSScrollBar.scroll();
    }
}
