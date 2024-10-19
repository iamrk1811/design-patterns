package patterns.structural;

/*
 * Bridge: separates the abstraction (Vehicle) from its implementation (Engine)
 * so that they can grow independently.
 */

interface Engine {
    public void buildEngine();
}

class PetrolEngine implements Engine {
    @Override
    public void buildEngine() {
        System.out.println("Building a petrol engine.");
    }
}

class DieselEngine implements Engine {
    @Override
    public void buildEngine() {
        System.out.println("Building a diesel engine.");
    }
}

abstract class Vehicle {
    protected Engine engine;

    Vehicle(Engine engine) {
        this.engine = engine;
    }

    public abstract void drive();
}

class Car extends Vehicle {
    Car(Engine engine) {
        super(engine);
    }

    @Override
    public void drive() {
        engine.buildEngine();
        System.out.println("Driving a car.");
    }
}

class Bike extends Vehicle {
    Bike(Engine engine) {
        super(engine);
    }

    @Override
    public void drive() {
        engine.buildEngine();
        System.out.println("Riding a bike.");
    }
}

class ClientBridge {
    public static void main(String[] args) {
        Vehicle carWithPetrolEngine = new Car(new PetrolEngine());
        carWithPetrolEngine.drive();

        Vehicle bikeWithDieselEngine = new Bike(new DieselEngine());
        bikeWithDieselEngine.drive();
    }
}
