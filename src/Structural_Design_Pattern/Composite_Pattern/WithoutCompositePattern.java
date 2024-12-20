package Structural_Design_Pattern.Composite_Pattern;

import java.util.ArrayList;
import java.util.List;

class File {
    private final String name;

    File(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.println(this.name);
    }
}

class Folder {
    private final String name;
    // Folder should be able to hold both files and folder itself
    // here we are only using files
    // it should uniformly able to accept both
    List<File> files;

    Folder(String name) {
        this.name = name;
        files = new ArrayList<>();
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void showDetails() {
        System.out.println(this.name);
        for (File file : files) {
            file.showDetails();
        }
    }
}

public class WithoutCompositePattern {
    public static void main(String[] args) {

        File file1 = new File("file1");
        File file2 = new File("file2");
        File file3 = new File("file3");
        File file4 = new File("file4");

        Folder folder = new Folder("folder");
        folder.addFile(file1);
        folder.addFile(file2);
        folder.addFile(file3);
        folder.addFile(file4);

        folder.showDetails();
    }
}
