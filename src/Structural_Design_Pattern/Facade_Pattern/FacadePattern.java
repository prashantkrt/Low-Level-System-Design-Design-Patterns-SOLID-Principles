package Structural_Design_Pattern.Facade_Pattern;

class UserMicroService {
    public String getUserDetails(String userId) {
        return "User details with id " + userId;
    }
}

class OrderMicroService {
    public String getOrderDetails(String orderId) {
        return "Order details with id " + orderId;
    }
}

class PaymentMicroService {
    public String processPayment(String paymentId) {
        return "processing payment for " + paymentId;
    }
}

// API Gateway is the best example of a facade pattern
class APIGateway {
    private final UserMicroService userMicroService;
    private final OrderMicroService orderMicroService;
    private final PaymentMicroService paymentMicroService;

    public APIGateway(UserMicroService userMicroService, OrderMicroService orderMicroService, PaymentMicroService paymentMicroService) {
        this.userMicroService = userMicroService;
        this.orderMicroService = orderMicroService;
        this.paymentMicroService = paymentMicroService;
    }

    public String getFullOrderDetails(String userId, String oderId, String paymentId) {
        return userMicroService.getUserDetails(userId) + "\n" + orderMicroService.getOrderDetails(oderId) + "\n" + paymentMicroService.processPayment(paymentId);
    }

}

public class FacadePattern {
    public static void main(String[] args) {
        UserMicroService userMicroService = new UserMicroService();
        OrderMicroService orderMicroService = new OrderMicroService();
        PaymentMicroService paymentMicroService = new PaymentMicroService();

        //The Client is now interacting with APIGateway instead of individual microservices, which reduces the complexity of the code
        //API Gateway, will reduce the complexity
        APIGateway apiGateway = new APIGateway(userMicroService, orderMicroService, paymentMicroService);
        String fullDetails = apiGateway.getFullOrderDetails(userMicroService.getUserDetails("123"), "123", "123");
        System.out.println(fullDetails);

    }
}
