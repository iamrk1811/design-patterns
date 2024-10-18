package patterns.creational;

/*
 * Factory: creates object without exposing the creation logic
 */


 interface Vehicle {
    public void drive();
 }

 class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("driving car");
    }
 }

 class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("driving bike");
    }
 }

/*
 * So basically you don't have to worry how a object being created whats the
 * logic behind it. Below creation logic is simple, but in real world scenario
 * logic can be much more complex, so if you don't want to expose creational logic
 * this is the pattern you are looking for.
 */
 class VehicleFactory {
    public Vehicle getVehicle(int type) {
        if (type == 1) {
            return new Car();
        } else if (type == 2) {
            return new Bike();
        }
        return null;
    }
 }


 class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new VehicleFactory().getVehicle(1);
        vehicle.drive();
    }
}