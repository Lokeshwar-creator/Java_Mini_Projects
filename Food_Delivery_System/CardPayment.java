public class CardPayment implements Payment {

    private String cardNumber;

    public CardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {

        System.out.println(
                "₹" + amount +
                " paid successfully using card ending ****" +
                getLastFourDigits()
        );
    }

    @Override
    public void refund(double amount) {

        System.out.println(
                "₹" + amount +
                " refunded to card ending ****" +
                getLastFourDigits()
        );
    }

    private String getLastFourDigits() {

        if (cardNumber.length() <= 4) {
            return cardNumber;
        }

        return cardNumber.substring(
                cardNumber.length() - 4
        );
    }
}