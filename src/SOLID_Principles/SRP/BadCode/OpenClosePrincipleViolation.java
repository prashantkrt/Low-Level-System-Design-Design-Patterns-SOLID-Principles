package SOLID_Principles.SRP.BadCode;

// Classes, modules, functions, etc. Should be open for extension but closed for modification
// Problem in the below example is that suppose I have to add a new case for UPI then I have to modify the exiting code which is tested already
class PaymentProcessor {

    public void processPayment(String paymentMethod, double amount) {

        if (paymentMethod.equals("CreditCard")) {
            System.out.println("Making payment via CreditCard amount " + amount);
        }
        else if(paymentMethod.equals("Cash")) {
            System.out.println("Making payment via Cash amount " + amount);
        }
        else if(paymentMethod.equals("DebitCard")) {
            System.out.println("Making payment via DebitCard amount " + amount);
        }
        else{
            throw new IllegalArgumentException("Invalid payment method");
        }
    }
}

public class OpenClosePrincipleViolation {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.processPayment("CreditCard", 100.0);
    }
}
