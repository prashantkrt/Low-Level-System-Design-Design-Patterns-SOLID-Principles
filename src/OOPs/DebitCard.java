package OOPs;

import javax.smartcardio.Card;

public class DebitCard extends Cards {

    public DebitCard(String cardName, String cardNumber) {
        super(cardName, cardNumber);
    }

    @Override
    public void pay() {
        System.out.println("Payment is made through Debit Card");
    }
}
