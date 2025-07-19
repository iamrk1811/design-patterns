package patterns.structural;

/*
 * Adapter: allows objects with incompatible interface to work
 * together by act as a bridge
 */

// target interface
interface TypeC {
    public void fastCharge();
}

// Adaptee class
class NormalCharger {
    public void normalCharge() {
        System.out.println("Charging at normal speed.");
    }
}

// Adapter class
class TypeCToNormalCharger implements TypeC {
    private NormalCharger charger;
    TypeCToNormalCharger(NormalCharger charger) {
        this.charger = charger;
    }

    public void fastCharge() {
        System.out.println("Attempting to fast charge...");
        this.charger.normalCharge();
    }
}


/*
 * As you can see, a Type-C charger can charge devices quickly.
 * However, if a Type-C charger is not compatible, it should 
 * still provide some charge, albeit at a slower rate, 
 * rather than not charging at all.
 */

class ClientAdapter {
    public static void main(String[] args) {
        TypeCToNormalCharger adapter = new TypeCToNormalCharger(new NormalCharger());
        adapter.fastCharge();
    }
}
