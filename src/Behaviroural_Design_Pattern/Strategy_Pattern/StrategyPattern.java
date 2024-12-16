package Behaviroural_Design_Pattern.Strategy_Pattern;

interface PaymentStrategy {
    void processPayment(double amount);
}

class DebitPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Payment processed through DebitCard " + amount);
    }
}

class CreditPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Payment Processed through CreditCard " + amount);
    }
}

//strategy class to set the payment type
class PaymentServiceStrategy {

    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount) {
        paymentStrategy.processPayment(amount);
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        PaymentServiceStrategy paymentServiceStrategy = new PaymentServiceStrategy();
        paymentServiceStrategy.setPaymentStrategy(new DebitPayment());
        paymentServiceStrategy.pay(10);

        paymentServiceStrategy.setPaymentStrategy(new CreditPayment());
        paymentServiceStrategy.pay(10);
    }
}
