package SOLID_Principles.SRP.GoodCode;

//Open for extension and closed for modification

//Now if we have to add a new payment method, we can add it without making any modification
interface PaymentMethod {
    public void processPayment(double amount);
}

class CreditCard implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Credit Card Payment amount: " + amount);
    }
}

class DebitCard implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Debit Card Payment amount: " + amount);
    }
}

class Cash implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Cash Payment amount: " + amount);
    }
}


//added new payment method without making changes to existing code
//open for extension but closed for modification
class UPI implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("UPI Payment amount: " + amount);
    }
}

public class OpenClosePrinciple {
    public static void main(String[] args) {
        PaymentMethod paymentMethod = new CreditCard();
        paymentMethod.processPayment(10);
        PaymentMethod paymentMethod2 = new UPI();
        paymentMethod2.processPayment(10);
    }
}
