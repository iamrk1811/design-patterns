package patterns.creational;


/*
 * Builder: lets you create complex object step by step
 */

class Pizza {
    String souce, dough, etc;
    private Pizza(PizzaBuilder builder) {
        this.souce = builder.souce;
        this.dough = builder.souce;
        this.etc = builder.etc;
    }

    static class PizzaBuilder {
        String souce, dough, etc;
        PizzaBuilder setSouce(String souce) {
            this.souce = souce;
            return this;
        }

        PizzaBuilder setDough(String dough) {
            this.dough = dough;
            return this;
        }

        PizzaBuilder setEtc(String etc) {
            this.etc = etc;
            return this;
        }

        Pizza build() {
            return new Pizza(this);
        }
    }
}


class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza.PizzaBuilder()
            .setSouce("red one")
            .setDough("any")
            .setEtc("avoid over engineering")
            .build();
    }
}