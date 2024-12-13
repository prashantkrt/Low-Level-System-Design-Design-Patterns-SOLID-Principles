package SOLID_Principles.SRP.BadCode;

//Class should not be a burden that the methods which they don't need


class Document {
  // some dummy class document
}


// this is a big interface
interface Machine {
    void print(Document document);

    void scan(Document document);

    void copy(Document document);
}

// supposed to only print
class SimplePrinter implements Machine {


    @Override
    public void print(Document document) {
        System.out.println("Document will be printed");
    }

    //not needed but forced to implement
    @Override
    public void scan(Document document) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void copy(Document document) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

class MultiPurposePrinter implements Machine {
    @Override
    public void print(Document document) {
        System.out.println("Document will be printed");
    }

    @Override
    public void scan(Document document) {
        System.out.println("Document will be scanned");
    }

    @Override
    public void copy(Document document) {
        System.out.println("Document will be copied");
    }
}


public class InterfaceSegregationPrincipleViolation {
    public static void main(String[] args) {

    }
}
