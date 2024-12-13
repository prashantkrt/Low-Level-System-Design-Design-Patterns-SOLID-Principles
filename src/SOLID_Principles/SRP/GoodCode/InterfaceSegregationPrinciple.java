package SOLID_Principles.SRP.GoodCode;

class Document {

}

//Segregated the interface into multiple smaller interfaces
interface Printer {
    void print(Document document);
}

interface Copier {
    void copy(Document document);
}

interface Scanner {
    void scan(Document document);
}


class SimplePrinter implements Printer {

    @Override
    public void print(Document document) {
        System.out.println("Document will be printed");
    }
}

class MultiPurposePrinter implements Printer, Copier, Scanner {
    @Override
    public void copy(Document document) {
        System.out.println("Document will be copied");
    }

    @Override
    public void print(Document document) {
        System.out.println("Document will be printed");
    }

    @Override
    public void scan(Document document) {
        System.out.println("Document will be scanned");
    }
}

public class InterfaceSegregationPrinciple {
    public static void main(String[] args) {
     Printer printer = new MultiPurposePrinter();
     printer.print(new Document());

     MultiPurposePrinter printer2 = new MultiPurposePrinter();
     printer2.print(new Document());
     printer2.scan(new Document());
     printer2.copy(new Document());

    }
}
