package Creational_Design_Pattern.AbstractFactory_Pattern;

interface Button {
    void render();
}

class WindowButton implements Button {
    @Override
    public void render() {
        System.out.println("WindowButton");
    }
}

class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("MacButton");
    }
}

interface Scroll {
    void scroll();
}

class WindowScroll implements Scroll {
    @Override
    public void scroll() {
        System.out.println("WindowScroll");
    }
}

class MacScroll implements Scroll {
    @Override
    public void scroll() {
        System.out.println("MacScroll");
    }
}

//Abstract Factory , factory of factory
interface ComponentFactory {
   Button createButton(String osType);
   Scroll createScroll(String osType);
}

//factory 1
class MacComponentFactory implements ComponentFactory {
    @Override
    public Button createButton(String osType) {
        return new MacButton();
    }

    @Override
    public Scroll createScroll(String osType) {
        return new MacScroll();
    }
}


//factory 2
class WindowComponentFactory implements ComponentFactory {
    @Override
    public Button createButton(String osType) {
        return new WindowButton();
    }

    @Override
    public Scroll createScroll(String osType) {
        return new WindowScroll();
    }
}


// master factory best create this master as well :)
// without this also we can write it
class MasterFactory  {
    public static ComponentFactory createButton(String osType) {
       return switch (osType) {
            case "Window" -> new WindowComponentFactory();
            case "Mac" -> new MacComponentFactory();
            default -> throw new IllegalArgumentException("Unknown OS type: " + osType);
        };
    }
}



//client
public class AbstractFactoryPattern {
    public static void main(String[] args) {
        //better way
        ComponentFactory factory = MasterFactory.createButton("Window");
        Button button = factory.createButton("Window");
        Scroll scroll = factory.createScroll("Window");
        button.render();
        scroll.scroll();

        //without master
        ComponentFactory factory2 = new WindowComponentFactory();
        Button button2 = factory2.createButton("Mac");
        Scroll scroll2 = factory2.createScroll("Mac");
        button2.render();
        scroll2.scroll();
    }
}
