package patterns.structural;

import java.util.ArrayList;
import java.util.List;

/*
 * Composite: treats individual objects and compositions of objects uniformly
 */

interface FileSystemComponent {
    public void view();
}

class File implements FileSystemComponent {
    private String name;
    
    File(String name) {
        this.name = name;
    }
    @Override
    public void view() {
        System.out.println("showing file : " + this.name);
    }
}

class Folder implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> list;

    Folder(String name) {
        this.name = name;
        this.list = new ArrayList<>();
    }

    @Override
    public void view() {
        System.out.println("showing conent of : " + this.name);
        for (FileSystemComponent component: list) {
            component.view();
        }
    }

    public void addComponent(FileSystemComponent component) {
        this.list.add(component);
    }
}


 class Main {
    public static void main(String[] args) {
        File file1 = new File("file1.txt");
        File file2 = new File("file2.java");

        Folder folder1 = new Folder("codes");
        Folder inner = new Folder("sub folder");

        folder1.addComponent(file1);
        folder1.addComponent(file2);
        folder1.addComponent(inner);

        folder1.view();
    }
 }