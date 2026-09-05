import java.util.ArrayList;

public class Order {

    private int orderId;

    private Customer customer;

    private Restaurant restaurant;

    private ArrayList<Fooditem> items;

    private double totalAmount;

    private OrderStatus status;

    private Payment payment;

    private Delivery delivery;

    public Order(
            int orderId,
            Customer customer,
            Restaurant restaurant,
            ArrayList<Fooditem> items) {

        this.orderId = orderId;
        this.customer = customer;
        this.restaurant = restaurant;

        this.items = new ArrayList<>(items);

        this.totalAmount = calculateTotal();

        this.status = OrderStatus.PLACED;
    }

    private double calculateTotal() {

        double total = 0;

        for (Fooditem item : items) {
            total += item.getPrice();
        }

        return total;
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void makePayment(Payment payment) {

        this.payment = payment;

        payment.pay(totalAmount);
    }

    public void assignDelivery(Delivery delivery) {

        this.delivery = delivery;

        System.out.println(
                "Delivery partner assigned successfully."
        );
    }

    public void updateStatus(OrderStatus status) {

        if (this.status == OrderStatus.CANCELLED ||
            this.status == OrderStatus.DELIVERED) {

            System.out.println(
                    "Order cannot be updated."
            );

            return;
        }

        this.status = status;

        System.out.println(
                "Order status updated to: " +
                status
        );
    }

    public void cancelOrder() {

        if (status == OrderStatus.DELIVERED) {

            System.out.println(
                    "Delivered order cannot be cancelled."
            );

            return;
        }

        if (status == OrderStatus.OUT_FOR_DELIVERY) {

            System.out.println(
                    "Order is already out for delivery."
            );

            return;
        }

        status = OrderStatus.CANCELLED;

        System.out.println(
                "Order cancelled successfully."
        );
    }

    public void displayOrder() {

        System.out.println("\n========== ORDER ==========");

        System.out.println(
                "Order ID   : " +
                orderId
        );

        System.out.println(
                "Customer   : " +
                customer.getName()
        );

        System.out.println(
                "Restaurant : " +
                restaurant.getName()
        );

        System.out.println("\nItems:");

        for (Fooditem item : items) {
            item.displayItem();
        }

        System.out.println(
                "\nTotal      : ₹" +
                totalAmount
        );

        System.out.println(
                "Status     : " +
                status
        );

        if (delivery != null) {
            System.out.println(
                    "Delivery   : " +
                    delivery.getStatus()
            );
        }
    }
}