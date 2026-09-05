public class DeliveryPartner {

    private int partnerId;
    private String name;
    private String phone;

    public DeliveryPartner(
            int partnerId,
            String name,
            String phone) {

        this.partnerId = partnerId;
        this.name = name;
        this.phone = phone;
    }

    public int getPartnerId() {
        return partnerId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void displayPartner() {

        System.out.println(
                "Delivery Partner: " +
                name
        );

        System.out.println(
                "Phone: " +
                phone
        );
    }
}