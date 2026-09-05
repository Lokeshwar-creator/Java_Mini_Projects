public class Delivery {

    private int deliveryId;

    private DeliveryPartner deliveryPartner;

    private String deliveryAddress;

    private DeliveryStatus status;

    public Delivery(
            int deliveryId,
            DeliveryPartner deliveryPartner,
            String deliveryAddress) {

        this.deliveryId = deliveryId;
        this.deliveryPartner = deliveryPartner;
        this.deliveryAddress = deliveryAddress;

        this.status = DeliveryStatus.ASSIGNED;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public DeliveryPartner getDeliveryPartner() {
        return deliveryPartner;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public DeliveryStatus getStatus() {
        return status;
    }

    public void updateStatus(DeliveryStatus status) {
        this.status = status;
    }

    public void displayDelivery() {

        System.out.println("\n===== DELIVERY DETAILS =====");

        System.out.println(
                "Delivery ID : " +
                deliveryId
        );

        System.out.println(
                "Address     : " +
                deliveryAddress
        );

        deliveryPartner.displayPartner();

        System.out.println(
                "Status      : " +
                status
        );
    }
}