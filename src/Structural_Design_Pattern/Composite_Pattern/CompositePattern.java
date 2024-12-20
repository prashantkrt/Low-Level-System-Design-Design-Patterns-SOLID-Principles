package Structural_Design_Pattern.Composite_Pattern;

import java.util.ArrayList;
import java.util.List;

interface FileSystemComponent {
    public void showDetails();
}

class Files implements FileSystemComponent {

    private String fileName;

    public Files(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void showDetails() {
        System.out.println(fileName);
    }
}

class Directories implements FileSystemComponent {

    private String fileName;

    // Folder should be able to hold both files and folder itself
    private List<FileSystemComponent> components;

    public Directories(String fileName) {
        this.fileName = fileName;
        components = new ArrayList<>();
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    @Override
    public void showDetails() {
        System.out.println(fileName);
        for (FileSystemComponent component : components) {
            component.showDetails();
        }
    }
}

public class CompositePattern {
    public static void main(String[] args) {
        Files files1 = new Files("files");
        Files files2 = new Files("files2");
        Files files3 = new Files("files3");

        Directories directories = new Directories("Sub Folder");
        directories.addComponent(files1);
        directories.addComponent(files2);
        directories.addComponent(files3);

        Directories main = new Directories("Main Folder");
        main.addComponent(directories);
        main.showDetails();
    }
}
