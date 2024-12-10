package SOLID_Principles.SRP.GoodCode;

//only add the invoice related method or operations
class Invoice {
    private final double amount;

    public Invoice(double amount) {
        this.amount = amount;
    }

    public void generateInvoice() {
        System.out.println("Invoice Generated for the amount " + amount);
    }

}

//only add repo or databases related operations
class InvoiceRepository {

    public void save() {
        System.out.println("Invoice Saved");
    }
}


//oly add notification related operations
class Notification {

    public void sendNotification() {
        System.out.println("Notification Sent");
    }
}

public class SingleResponsibilityPrinciple {
    public static void main(String[] args) {
        Invoice invoice = new Invoice(10);
        invoice.generateInvoice();
        InvoiceRepository repository = new InvoiceRepository();
        repository.save();
        Notification notification = new Notification();
        notification.sendNotification();
    }
}
