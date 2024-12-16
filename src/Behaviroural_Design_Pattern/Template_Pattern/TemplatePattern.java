package Behaviroural_Design_Pattern.Template_Pattern;

abstract class DataParser{

    //The Template defines the steps of the algorithm
    public final void parse(){
        openFile();
        parseData();
        closeFile();
    }

    protected abstract void openFile();
    protected abstract void parseData();
    protected abstract void closeFile();
}

class CSVDataParser extends DataParser{
    @Override
    protected void openFile() {
        System.out.println("Opening CSV file");
    }

    @Override
    protected void parseData() {
     System.out.println("Parsing data");
    }

    @Override
    protected void closeFile() {
    System.out.println("Closing CSV file");
    }
}

class JSONDataParser extends DataParser{
    @Override
    protected void openFile() {
        System.out.println("Opening JSON file");
    }

    @Override
    protected void parseData() {
        System.out.println("Parsing data");
    }

    @Override
    protected void closeFile() {
        System.out.println("Closing JSON file");
    }
}
public class TemplatePattern {
    public static void main(String[] args) {
        DataParser parser = new CSVDataParser();
        parser.parse();
    }
}
