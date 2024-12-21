package Structural_Design_Pattern.Facade_Pattern;

//microservice 1
class UserService {
    public String getUserDetails(String userId) {
        return "User Details for " + userId + " is " + userId;
    }
}


//microservice 2
class OrderService{

    public String getOrderDetails(String orderId) {
        return "Order Details for " + orderId + " is " + orderId;
    }
}

//microservice 3
class PaymentService{
    public String processPayment(String paymentId) {
        return "Processing payment for " + paymentId;
    }
}


//client
public class WithoutFacadePattern {
    public static void main(String[] args) {
        UserService userService = new UserService();
        OrderService orderService = new OrderService();
        PaymentService paymentService = new PaymentService();

        //To do some work or task
        //tightly couple
        //exposing api to the clients
        System.out.println(userService.getUserDetails("123"));
        System.out.println(orderService.getOrderDetails("123"));
        System.out.println(paymentService.processPayment("123"));

    }
}
