public class CashPayment implements Payment {

    @Override
    public void pay(double amount) {

        System.out.println(
                "Cash on Delivery selected."
        );

        System.out.println(
                "Amount to collect: ₹" + amount
        );
    }

    @Override
    public void refund(double amount) {

        System.out.println(
                "Cash refund of ₹" +
                amount +
                " will be processed."
        );
    }
}