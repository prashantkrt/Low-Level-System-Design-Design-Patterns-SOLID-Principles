package OOPs;

public class CreditCard extends Cards{

    public CreditCard(String cardName, String cardNumber) {
        super(cardName, cardNumber);
    }

    @Override
    public void pay() {
        System.out.println("Payment is made through CreditCard");
    }
}
