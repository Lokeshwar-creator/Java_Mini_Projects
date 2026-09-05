public class UPIPayment implements Payment {

    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(double amount) {

        System.out.println(
                "₹" + amount +
                " paid successfully using UPI: " +
                upiId
        );
    }

    @Override
    public void refund(double amount) {

        System.out.println(
                "₹" + amount +
                " refunded to UPI: " +
                upiId
        );
    }
}