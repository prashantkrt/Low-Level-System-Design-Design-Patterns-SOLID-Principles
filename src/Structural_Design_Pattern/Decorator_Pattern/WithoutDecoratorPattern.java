package Structural_Design_Pattern.Decorator_Pattern;
// problem of scalability like can have many combinations that can lead to class explosion
interface Pizza {
    String getDescription();

    double getCost();
}

// class explosions for all declarations and variant
class BasicPizza implements Pizza {

    @Override
    public String getDescription() {
        return "basic pizza ";
    }

    @Override
    public double getCost() {
        return 10.00;
    }
}

// Paneer pizza can have its own hierarchy
// multiple class explosions paneer variant like cheese, Olive and Mushroom
class PaneerPizza extends BasicPizza {

    @Override
    public String getDescription() {
        return super.getDescription() + "with Panner topping ";
    }

    @Override
    public double getCost() {
        return super.getCost() + 15.00;
    }
}

// multiple class explosions cheese variant like Olive and Mushroom
class CheesePizza extends BasicPizza {
    @Override
    public String getDescription() {
        return super.getDescription() + "with Cheese ";
    }

    @Override
    public double getCost() {
        return super.getCost() + 5.00;
    }
}
// cheese me -> olive aur mushroom
class CheeseOlivePizza extends CheesePizza {
    @Override
    public String getDescription() {
        return super.getDescription() + "and with Cheese Olive ";
    }

    @Override
    public double getCost() {
        return super.getCost() + 5.00;
    }
}

class MushroomPizza extends CheesePizza {
    @Override
    public String getDescription() {
        return super.getDescription() + "and with Mushroom ";
    }

    @Override
    public double getCost() {
        return super.getCost() + 5.00;
    }
}


//Pizza App
public class WithoutDecoratorPattern {
    public static void main(String[] args) {
        Pizza pizza = new BasicPizza();
        System.out.println(pizza.getDescription());
        System.out.println(pizza.getCost());

        pizza = new CheesePizza();
        System.out.println(pizza.getDescription());
        System.out.println(pizza.getCost());

        pizza = new CheeseOlivePizza();
        System.out.println(pizza.getDescription());
        System.out.println(pizza.getCost());

        pizza = new MushroomPizza();
        System.out.println(pizza.getDescription());
        System.out.println(pizza.getCost());

        Pizza pizza1 = new BasicPizza();
        pizza1 = new PaneerPizza();
        System.out.println(pizza1.getDescription());
        System.out.println(pizza1.getCost());

        pizza1 = new CheeseOlivePizza();
        System.out.println(pizza1.getDescription());
        System.out.println(pizza1.getCost());
    }
}
