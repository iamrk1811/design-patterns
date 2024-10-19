package patterns.structural;


/*
 * Decorator: allows you to add or modify features dynamically to an object.
 */

 interface Pizza {
    public int getPrice();
    public String makePizza();
 }

class NormalPizza implements Pizza {
    @Override
    public int getPrice() {
        return 5;
    }

    @Override
    public String makePizza() {
        return "Normal pizza";
    }
}

abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int getPrice() {
        return this.pizza.getPrice();
    }

    @Override
    public String makePizza() {
        return this.pizza.makePizza();
    }
}

class ToppingDecorator extends PizzaDecorator {
    ToppingDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public int getPrice() {
        return this.pizza.getPrice() + 10;
    }

    @Override
    public String makePizza() {
        return this.pizza.makePizza() + "topping";
    }
}


class Main {
    public static void main(String[] args) {
        Pizza pizza = new NormalPizza();

        Pizza toppingPizza = new ToppingDecorator(pizza);
    }
}