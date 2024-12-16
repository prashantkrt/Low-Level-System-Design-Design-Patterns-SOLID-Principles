package Behaviroural_Design_Pattern.Template_Pattern;

//CSV Parser
class CSVParser {

    public void parse() {
        System.out.println("CSV Parser");
        openFile();
        //some parsing logic
        System.out.println("Parsing the file");
        closeFile();
    }

    public void openFile() {
        System.out.println("Opening File");
    }

    public void closeFile() {
        System.out.println("Closing File");
    }
}

class JSONParser {

    public void parse() {
        System.out.println("JSON Parser");
        openFile();
        //some parsing logic
        System.out.println("Parsing the file");
        closeFile();
    }

    //duplicated
    public void openFile() {
        System.out.println("Opening File");
    }

    public void closeFile() {
        System.out.println("Closing File");
    }

}

public class WithoutTemplatePattern {
    public static void main(String[] args) {
        CSVParser csvParser = new CSVParser();
        csvParser.parse();
        JSONParser jsonParser = new JSONParser();
        jsonParser.parse();
    }
}
