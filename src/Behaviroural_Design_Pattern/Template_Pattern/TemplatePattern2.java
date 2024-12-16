package Behaviroural_Design_Pattern.Template_Pattern;
abstract class DataProcessor {
    public final void process() {
        loadData();
        processData();
        saveData();
    }

    // Common implementation
    void loadData() {
        System.out.println("Loading data...");
    }

    // Abstract methods to be implemented by subclasses
    abstract void processData();

    void saveData() {
        System.out.println("Saving data...");
    }
}

class TextDataProcessor extends DataProcessor {
    @Override
    void processData() {
        System.out.println("Processing text data...");
    }
}

class ExcelDataProcessor extends DataProcessor {
    @Override
    void processData() {
        System.out.println("Processing Excel data...");
    }
}
public class TemplatePattern2 {
    public static void main(String[] args) {

        DataProcessor textProcessor = new TextDataProcessor();
        textProcessor.process();

        System.out.println();

        DataProcessor excelProcessor = new ExcelDataProcessor();
        excelProcessor.process();

    }
}
