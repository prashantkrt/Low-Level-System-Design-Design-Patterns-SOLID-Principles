package OOPs;

public class Client {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        paymentService.addPaymentMethod("Prashant",new UPI("abc@upi"));
        paymentService.addPaymentMethod("Rakesh",new CreditCard("Rakesh Roshan","1234567"));

        paymentService.makePayment("Prashant");
        paymentService.makePayment("Rakesh");

    }
}
