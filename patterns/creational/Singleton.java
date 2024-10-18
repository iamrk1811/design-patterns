package patterns.creational;

/*
 * Singleton: ensure only one instance exists.
 * there are many implemention of Singleton design pattern
 * But most famous and used ones are:
 * 1. Eager, 2. Lazy, 3. Thread-safe (Double-checked locking)
 */


/*
 * Eager:
 * Thread safe but not lazy, create the instance as soon as the class is loaded
 */
class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {}

    public static EagerSingleton getInstance() {
        return instance;
    }
}
/*
 * Lazy:
 * Creats instance only when needed, but not thread safe.
 * Obviously we can work around to make it thread safe.
 */
class LazySinglton {
    private static LazySinglton instance;
    private LazySinglton() {}

    public static LazySinglton getInstance() {
        if (instance == null) {
            instance = new LazySinglton();
        }
        return instance;
    }
}

/*
 * Double check:
 * more efficient thread-safe approach that reduces the overhead of 
 * synchronization by checking twice (before and after acquiring the lock)
 */
class DoubleChecked {
    private static DoubleChecked instance;

    public static DoubleChecked getInstance() {
        if (instance == null) {  // First check
            synchronized (DoubleChecked.class) {
                if (instance == null) {  // Second check
                    instance = new DoubleChecked();
                }
            }
        }
        return instance;
    }
}


class Main {
    public static void main(String[] args) {
        DoubleChecked obj = DoubleChecked.getInstance();
    }
}