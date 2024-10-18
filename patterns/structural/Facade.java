package patterns.structural;

/*
 * Facade: Provides a simplified interface to a complex system, shielding the client from its complexities.
 */

// Subsystem 2: CPU
 class CPU {
    public void freeze() { }
    public void jump() {}
    public void execute() {}
}

// Subsystem 2: RAM
class RAM {
    public void load() {}
}

// Subsystem 3: Storage
class Storage {
    public void read() {}
}

// Facade class
class ComputerFacade {
    private CPU cpu;
    private RAM ram;
    private Storage storage;

    public ComputerFacade(CPU cpu, RAM ram, Storage storage) {
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
    }

    public void startComputer() {
        System.out.println("Starting the computer...");
        cpu.freeze();
        storage.read();
        ram.load();
        cpu.jump();
        cpu.execute();
    }
}

class Main {
    public static void main(String[] args) {
        CPU cpu = new CPU();
        RAM ram = new RAM();
        Storage storage =  new Storage();
        ComputerFacade facade = new ComputerFacade(cpu, ram, storage);
        facade.startComputer();
    }
}