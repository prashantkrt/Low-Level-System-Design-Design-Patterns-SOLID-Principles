package SOLID_Principles.BadCode;

// Here we should have used only invoice related methods instead of database and notification which violates the SRP
class Invoice {

    private final double amount;

    public Invoice(double amount) {
        this.amount = amount;
    }

    public void generateInvoice() {
        System.out.println("Invoice generated for the amount " + amount + ".");
    }

    //added unwanted and not related methods to invoice which therefore breaks the SRP
    public void saveToDatabase() {
        System.out.println("Saving to database!!");
    }

    public void sendNotification() {
        System.out.println("Sending notification!");
    }
}

//A class should have only one reason to change
public class SingleResponsibilityPrincipleViolation {
    public static void main(String[] args) {
        Invoice invoice = new Invoice(10.0);
        invoice.generateInvoice();
    }
}
