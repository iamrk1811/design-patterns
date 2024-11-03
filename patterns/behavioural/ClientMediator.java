package patterns.behavioural;

/*
 * Mediator: facilitates communication between objects by introducing a mediator object
 */
interface AirTrafficControl {
    void requestLanding(Airplane airplane);
    void requestTakeoff(Airplane airplane);
    void releaseRunway();
}

class ControlTower implements AirTrafficControl {
    private boolean runwayInUse = false;

    @Override
    public void requestLanding(Airplane airplane) {
        if (!runwayInUse) {
            System.out.println(airplane.getId() + " landing.");
            runwayInUse = true;
            releaseRunway();  // Automatically release after landing
        } else {
            System.out.println(airplane.getId() + " waiting to land.");
        }
    }

    @Override
    public void requestTakeoff(Airplane airplane) {
        if (!runwayInUse) {
            System.out.println(airplane.getId() + " taking off.");
            runwayInUse = true;
            releaseRunway();  // Automatically release after takeoff
        } else {
            System.out.println(airplane.getId() + " waiting to take off.");
        }
    }

    @Override
    public void releaseRunway() {
        System.out.println("Runway now free.");
        runwayInUse = false;
    }
}

class Airplane {
    private String id;
    private AirTrafficControl controlTower;

    public Airplane(String id, AirTrafficControl controlTower) {
        this.id = id;
        this.controlTower = controlTower;
    }

    public String getId() {
        return id;
    }

    public void land() {
        controlTower.requestLanding(this);
    }

    public void takeoff() {
        controlTower.requestTakeoff(this);
    }
}

// Usage
public class ClientMediator {
    public static void main(String[] args) {
        ControlTower controlTower = new ControlTower();
        Airplane plane1 = new Airplane("Plane 101", controlTower);
        Airplane plane2 = new Airplane("Plane 202", controlTower);

        plane1.land();
        plane2.land();
        plane2.takeoff();
    }
}