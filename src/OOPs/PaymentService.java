package OOPs;

import java.util.HashMap;

public class PaymentService {

    private final HashMap<String, PaymentMethod> map;

    private String userName;
    private String paymentMethod;

    public PaymentService() {
        map = new HashMap<>();
    }

    public void addPaymentMethod(String userName, PaymentMethod paymentMethod) {
        map.put(userName, paymentMethod);
    }

    public void makePayment(String userName) {
        PaymentMethod paymentMethod = map.get(userName);
        paymentMethod.pay();
    }

}
