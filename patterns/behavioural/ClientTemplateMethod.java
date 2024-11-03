package patterns.behavioural;

/*
 * Template Method: lets you define basic steps of an algorithm in a method
 */

abstract class DataProcessor {
    void processData() {
        load();
        process();
        save();
    }
    protected abstract void load();
    protected abstract void process();
    protected abstract void save();
}

class CSVProcessor extends DataProcessor {

    @Override
    protected void load() {
        System.out.println("loading csv data");
    }

    @Override
    protected void process() {
        System.out.println("processing csv data");
    }

    @Override
    protected void save() {
        System.out.println("saving data in disk");
    }
    
}

class JSONProcessor extends DataProcessor {

    @Override
    protected void load() {
        System.out.println("loading json data");
    }

    @Override
    protected void process() {
        System.out.println("processing json data");
    }

    @Override
    protected void save() {
        System.out.println("saving data into DB");
    }
    
}

public class ClientTemplateMethod {
    public static void main(String[] args) {
        DataProcessor csv = new CSVProcessor();
        csv.processData();

        DataProcessor json = new JSONProcessor();
        json.processData();
    }
}
