package OOPs;

public abstract class Cards implements PaymentMethod{

    private final String cardName;
    private final String cardNumber;

    public Cards(String cardName, String cardNumber) {
        this.cardName = cardName;
        this.cardNumber = cardNumber;
    }

    public String getCardName() {
        return cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}
