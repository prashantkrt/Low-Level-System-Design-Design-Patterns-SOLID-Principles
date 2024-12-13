package SOLID_Principles.BadCode;

//Object of the superclass is replaceable with an object of the subclass class
//Ensures that the child class can stand in for its parent class and function correctly in any context that expects the parent class.

class File {

    public void read() {
        System.out.println("Reading file");
    }

    public void write() {
        System.out.println("writing file");
    }
}

class ReadOnly extends File {

    @Override
    public void read() {
        System.out.println("Reading read-only file");
    }

    //This is specific to read-only we cannot use write operation
    @Override
    public void write() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

public class LiskovSubstitutionPrincipleViolation {
    public static void main(String[] args) {
        File file = new File();
        file.read(); // works fine
        file.write(); // works fine

        //now let's use a child object
        file = new ReadOnly();
        file.read(); // works fine
        file.write();// exception will come violation of lsp
    }
}
