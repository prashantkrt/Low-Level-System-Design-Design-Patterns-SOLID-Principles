package Structural_Design_Pattern.Decorator_Pattern;

interface MyPizza {
    String getDescription();

    double getPrice();
}

class Basic implements MyPizza {

    @Override
    public String getDescription() {
        return "Basic Pizza";
    }

    @Override
    public double getPrice() {
        return 10.00;
    }
}
// With this approach, we don't have to create for every type, and its hierarchy
// lets say basic Pizza -> Cheese Basic -> Cheese Basic with mushroom -> Cheese Pizza With mushroom with olive.
// No need all separate classes for and its combinations
// Instead use decorator class to decorate instead of explosion for multiple subclass for each type

//abstract class so that we won't be able to create the object since we don't know which decorator type we have to implement
abstract class PizzaDecorator implements MyPizza {

    protected MyPizza pizza;

    public PizzaDecorator(MyPizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public double getPrice() {
        return pizza.getPrice();
    }
}

class CheeseDecorator extends PizzaDecorator {

    public CheeseDecorator(MyPizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " with cheese";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice()+5.00;
    }
}

class MushroomDecorator extends PizzaDecorator {

    public MushroomDecorator(MyPizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription()+" with mushroom";
    }

    @Override
    public double getPrice() {
        return super.getPrice()+5.00;
    }
}

class OliveDecorator extends PizzaDecorator {
    private MyPizza pizza;

    public OliveDecorator(MyPizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription()+" with olive";
    }

    @Override
    public double getPrice() {
        return super.getPrice()+5.00;
    }
}

//Pizza Application
public class DecoratorPattern {
    public static void main(String[] args) {
        //Basic Pizza
         MyPizza pizza = new Basic();
         pizza = new CheeseDecorator(pizza);
         pizza = new MushroomDecorator(pizza);
         pizza = new OliveDecorator(pizza);

         System.out.println(pizza.getDescription());
         System.out.println(pizza.getPrice());

    }
}
