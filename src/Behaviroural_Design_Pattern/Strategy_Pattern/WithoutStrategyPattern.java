package Behaviroural_Design_Pattern.Strategy_Pattern;

class PaymentService {

    public void processPayment(String paymentType) {
        if (paymentType.equalsIgnoreCase("Cash")) {
            System.out.println("Making payment via cash");
        } else if (paymentType.equalsIgnoreCase("UPI")) {
            System.out.println("Making payment via UPI");
        } else if (paymentType.equalsIgnoreCase("CreditCard")) {
            System.out.println("Making payment via credit card");
        } else if (paymentType.equalsIgnoreCase("DebitCard")) {
            System.out.println("Making payment via debit card");
        } else {
            System.out.println("Invalid payment type");
        }
    }
}

public class WithoutStrategyPattern {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        paymentService.processPayment("Cash");
    }
}
