package SOLID_Principles.GoodCode;

interface Readable {
    void read();
}

interface Writable {
    void write();
}

class ReadableFile implements Readable {
    @Override
    public void read() {
        System.out.println("Reading a file");
    }
}

class WritableFile implements Writable, Readable {
    @Override
    public void write() {
        System.out.println("Writing a file");
    }

    @Override
    public void read() {
        System.out.println("Reading a file");
    }
}

class WriteFile extends ReadableFile implements Writable {

    @Override
    public void write() {
        System.out.println("Writing a file");
    }
}

class ReadOnlyFile extends ReadableFile {}

public class LiskovSubstitutionPrinciple {
    public static void main(String[] args) {
        Readable readable = new ReadableFile();
        Writable writable = new WritableFile();
        readable.read();
        writable.write();
        writable.write();

        ReadableFile readableFile = new WriteFile();
        readableFile.read();

        ReadableFile readableFile2 = new ReadOnlyFile();
        readableFile2.read();
    }
}
