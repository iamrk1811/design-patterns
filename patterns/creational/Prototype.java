package patterns.creational;

/*
 * Prototype: lets you copy existing object without 
 * making your code dependent on their classes
 */

interface Shape {
    public Shape clone();
}

class Square implements Shape {
    String color;
    Square(String color) {
        this.color = color;
    }

    @Override
    public Shape clone() {
        return new Square(this.color);
    }
}

class Circle implements Shape {
    int size;
    Circle(int size) {
        this.size = size;
    }

    @Override
    public Shape clone() {
        return new Circle(this.size);
    }
}

class ClientPrototype {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape circleCopied = circle.clone();
    }
}