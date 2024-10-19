package patterns.creational;

/*
 * Abstract Factory: lets you create families of related objects
 * without specifying their concrete classes.
 */

interface Button {
    public void show();
}

interface Checkbox {
    public void show();
}

class AndroidButton implements Button {
    @Override
    public void show() {
        System.out.println("showing button in android");   
    }
}

class IOSButton implements Button {
    @Override
    public void show() {
        System.out.println("showing button in IOS");   
    }
}

class AndroidCheckbox implements Checkbox {
    @Override
    public void show() {
        System.out.println("showing checkbox in android");   
    }
}

class IOSCheckbox implements Checkbox {
    @Override
    public void show() {
        System.out.println("showing checkbox in IOS");   
    }
}

interface UIElementAbstractFactory {
    public Button createButton();
    public Checkbox createCheckbox();
}

class IOSFactory implements UIElementAbstractFactory {
    @Override
    public Button createButton() {
        return new IOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new IOSCheckbox();
    }
}

class AndroidFactory implements UIElementAbstractFactory {
    @Override
    public Button createButton() {
        return new AndroidButton();
    }
    @Override
    public Checkbox createCheckbox() {
        return new AndroidCheckbox();
    }
}

class View {
    public void show(UIElementAbstractFactory factory) {
        factory.createButton();
        factory.createCheckbox();
    }
}


class ClientAbstractFactory {
    public static void main(String[] args) {
        AndroidFactory androidFactory = new AndroidFactory();
        View v1 = new View();
        v1.show(androidFactory);


        IOSFactory iosFactory = new IOSFactory();
        View v2 = new View();
        v2.show(iosFactory);
    }
}