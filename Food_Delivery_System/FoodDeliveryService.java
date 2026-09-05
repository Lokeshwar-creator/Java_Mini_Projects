import java.util.ArrayList;

public class FoodDeliveryService {

    private ArrayList<Restaurant> restaurants;

    private ArrayList<Customer> customers;

    private ArrayList<Order> orders;

    private int nextOrderId = 1001;

    private int nextDeliveryId = 5001;

    public FoodDeliveryService() {

        restaurants = new ArrayList<>();
        customers = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public void addRestaurant(Restaurant restaurant) {

        restaurants.add(restaurant);
    }

    public void addCustomer(Customer customer) {

        customers.add(customer);
    }

    public void displayRestaurants() {

        System.out.println("\n===== RESTAURANTS =====");

        for (Restaurant restaurant : restaurants) {
            restaurant.displayRestaurant();
        }
    }

    public Restaurant findRestaurant(int restaurantId) {

        for (Restaurant restaurant : restaurants) {

            if (restaurant.getRestaurantId() == restaurantId) {
                return restaurant;
            }
        }

        return null;
    }

    public Customer findCustomer(int customerId) {

        for (Customer customer : customers) {

            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }

        return null;
    }

    public Order placeOrder(
            Customer customer,
            Restaurant restaurant) {

        if (customer.getCart().isEmpty()) {

            System.out.println(
                    "Cannot place order. Cart is empty."
            );

            return null;
        }

        ArrayList<Fooditem> items =
                new ArrayList<>(
                        customer.getCart().getItems()
                );

        Order order =
                new Order(
                        nextOrderId++,
                        customer,
                        restaurant,
                        items
                );

        orders.add(order);

        customer.getCart().clearCart();

        System.out.println(
                "\nOrder placed successfully!"
        );

        System.out.println(
                "Order ID: " +
                order.getOrderId()
        );

        return order;
    }

    public Order findOrder(int orderId) {

        for (Order order : orders) {

            if (order.getOrderId() == orderId) {
                return order;
            }
        }

        return null;
    }

    public void displayAllOrders() {

        if (orders.isEmpty()) {

            System.out.println(
                    "No orders available."
            );

            return;
        }

        for (Order order : orders) {
            order.displayOrder();
        }
    }

    public void assignDelivery(
            Order order,
            DeliveryPartner partner) {

        Delivery delivery =
                new Delivery(
                        nextDeliveryId++,
                        partner,
                        order.getCustomer().getAddress()
                );

        order.assignDelivery(delivery);
    }
}