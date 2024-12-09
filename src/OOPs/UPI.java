package OOPs;

public class UPI implements PaymentMethod{

    private final String upiID;

    public UPI(String upiID) {
        this.upiID = upiID;
    }

    public String getUpiID() {
        return upiID;
    }

    @Override
    public void pay() {
        System.out.println("Payment is made through UPI Payment Method");
    }
}
