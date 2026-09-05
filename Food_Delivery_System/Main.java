import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        FoodDeliveryService service = new FoodDeliveryService();

        loadSampleData(service);

        Customer currentCustomer = service.findCustomer(1);

        boolean running = true;

        System.out.println("\n========================================");
        System.out.println("       WELCOME TO FOOD DELIVERY");
        System.out.println("========================================");
        System.out.println("Hello, " + currentCustomer.getName() + "!");

        while (running) {

            displayMainMenu();

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    viewRestaurants(service);
                    break;

                case 2:
                    viewRestaurantMenu(service);
                    break;

                case 3:
                    addFoodToCart(service, currentCustomer);
                    break;

                case 4:
                    currentCustomer.viewCart();
                    break;

                case 5:
                    removeFoodFromCart(currentCustomer);
                    break;

                case 6:
                    placeOrder(service, currentCustomer);
                    break;

                case 7:
                    makePayment(service);
                    break;

                case 8:
                    updateOrderStatus(service);
                    break;

                case 9:
                    assignDelivery(service);
                    break;

                case 10:
                    trackOrder(service);
                    break;

                case 11:
                    cancelOrder(service);
                    break;

                case 12:
                    service.displayAllOrders();
                    break;

                case 13:
                    currentCustomer.displayCustomer();
                    break;

                case 0:
                    running = false;
                    System.out.println(
                            "\nThank you for using Food Delivery System!"
                    );
                    break;

                default:
                    System.out.println(
                            "\nInvalid choice. Please try again."
                    );
            }
        }

        scanner.close();
    }


    // =====================================================
    // MAIN MENU
    // =====================================================

    private static void displayMainMenu() {

        System.out.println("\n========================================");
        System.out.println("        FOOD DELIVERY SYSTEM");
        System.out.println("========================================");

        System.out.println("1.  View Restaurants");
        System.out.println("2.  View Restaurant Menu");
        System.out.println("3.  Add Food to Cart");
        System.out.println("4.  View Cart");
        System.out.println("5.  Remove Food from Cart");
        System.out.println("6.  Place Order");
        System.out.println("7.  Make Payment");
        System.out.println("8.  Update Order Status");
        System.out.println("9.  Assign Delivery Partner");
        System.out.println("10. Track Order");
        System.out.println("11. Cancel Order");
        System.out.println("12. View All Orders");
        System.out.println("13. View Customer Profile");
        System.out.println("0.  Exit");

        System.out.println("========================================");
    }


    // =====================================================
    // SAMPLE DATA
    // =====================================================

    private static void loadSampleData(
            FoodDeliveryService service) {

        // ---------------- RESTAURANT 1 ----------------

        Restaurant spiceHub =
                new Restaurant(
                        1,
                        "Spice Hub",
                        "Chennai"
                );

        spiceHub.addFoodItem(
                new Fooditem(
                        101,
                        "Chicken Biryani",
                        250,
                        "Main Course"
                )
        );

        spiceHub.addFoodItem(
                new Fooditem(
                        102,
                        "Paneer Butter Masala",
                        180,
                        "Main Course"
                )
        );

        spiceHub.addFoodItem(
                new Fooditem(
                        103,
                        "Garlic Naan",
                        60,
                        "Bread"
                )
        );


        // ---------------- RESTAURANT 2 ----------------

        Restaurant pizzaCorner =
                new Restaurant(
                        2,
                        "Pizza Corner",
                        "Chennai"
                );

        pizzaCorner.addFoodItem(
                new Fooditem(
                        201,
                        "Veg Pizza",
                        220,
                        "Pizza"
                )
        );

        pizzaCorner.addFoodItem(
                new Fooditem(
                        202,
                        "Chicken Pizza",
                        280,
                        "Pizza"
                )
        );

        pizzaCorner.addFoodItem(
                new Fooditem(
                        203,
                        "Cold Drink",
                        80,
                        "Beverage"
                )
        );


        // ---------------- ADD RESTAURANTS ----------------

        service.addRestaurant(spiceHub);
        service.addRestaurant(pizzaCorner);


        // ---------------- CUSTOMER ----------------

        Customer customer =
                new Customer(
                        1,
                        "Lokesh",
                        "9876543210",
                        "Chennai"
                );

        service.addCustomer(customer);
    }


    // =====================================================
    // VIEW RESTAURANTS
    // =====================================================

    private static void viewRestaurants(
            FoodDeliveryService service) {

        service.displayRestaurants();
    }


    // =====================================================
    // VIEW RESTAURANT MENU
    // =====================================================

    private static void viewRestaurantMenu(
            FoodDeliveryService service) {

        service.displayRestaurants();

        int restaurantId =
                readInt("\nEnter restaurant ID: ");

        Restaurant restaurant =
                service.findRestaurant(restaurantId);

        if (restaurant == null) {

            System.out.println(
                    "Restaurant not found."
            );

            return;
        }

        restaurant.displayMenu();
    }


    // =====================================================
    // ADD FOOD TO CART
    // =====================================================

    private static void addFoodToCart(
            FoodDeliveryService service,
            Customer customer) {

        System.out.println("\n===== ADD FOOD TO CART =====");

        service.displayRestaurants();

        int restaurantId =
                readInt(
                        "\nEnter restaurant ID: "
                );

        Restaurant restaurant =
                service.findRestaurant(restaurantId);

        if (restaurant == null) {

            System.out.println(
                    "Restaurant not found."
            );

            return;
        }

        restaurant.displayMenu();

        int itemId =
                readInt(
                        "\nEnter food item ID: "
                );

        Fooditem selectedItem = null;

        for (Fooditem item :
                restaurant.getMenu()) {

            if (item.getItemId() == itemId) {

                selectedItem = item;
                break;
            }
        }

        if (selectedItem == null) {

            System.out.println(
                    "Food item not found in this restaurant."
            );

            return;
        }

        customer.addToCart(selectedItem);
    }


    // =====================================================
    // REMOVE FOOD FROM CART
    // =====================================================

    private static void removeFoodFromCart(
            Customer customer) {

        System.out.println("\n===== REMOVE FOOD =====");

        customer.viewCart();

        if (customer.getCart().isEmpty()) {
            return;
        }

        int itemId =
                readInt(
                        "\nEnter food item ID to remove: "
                );

        customer.removeFromCart(itemId);
    }


    // =====================================================
    // PLACE ORDER
    // =====================================================

    private static void placeOrder(
            FoodDeliveryService service,
            Customer customer) {

        System.out.println("\n===== PLACE ORDER =====");

        customer.viewCart();

        if (customer.getCart().isEmpty()) {
            return;
        }

        service.displayRestaurants();

        int restaurantId =
                readInt(
                        "\nEnter restaurant ID: "
                );

        Restaurant restaurant =
                service.findRestaurant(restaurantId);

        if (restaurant == null) {

            System.out.println(
                    "Restaurant not found."
            );

            return;
        }

        Order order =
                service.placeOrder(
                        customer,
                        restaurant
                );

        if (order != null) {

            order.displayOrder();
        }
    }


    // =====================================================
    // MAKE PAYMENT
    // =====================================================

    private static void makePayment(
            FoodDeliveryService service) {

        System.out.println("\n===== PAYMENT =====");

        int orderId =
                readInt(
                        "Enter order ID: "
                );

        Order order =
                service.findOrder(orderId);

        if (order == null) {

            System.out.println(
                    "Order not found."
            );

            return;
        }

        if (order.getStatus() == OrderStatus.CANCELLED) {

            System.out.println(
                    "Cannot make payment for a cancelled order."
            );

            return;
        }

        System.out.println(
                "\nAmount to Pay: ₹" +
                order.getTotalAmount()
        );

        System.out.println("\nPayment Methods:");

        System.out.println("1. UPI");
        System.out.println("2. Card");
        System.out.println("3. Cash on Delivery");

        int choice =
                readInt(
                        "\nSelect payment method: "
                );

        Payment payment;

        switch (choice) {

            case 1:

                String upiId =
                        readString(
                                "Enter UPI ID: "
                        );

                payment =
                        new UPIPayment(upiId);

                break;


            case 2:

                String cardNumber =
                        readString(
                                "Enter card number: "
                        );

                payment =
                        new CardPayment(cardNumber);

                break;


            case 3:

                payment =
                        new CashPayment();

                break;


            default:

                System.out.println(
                        "Invalid payment method."
                );

                return;
        }

        order.makePayment(payment);
    }


    // =====================================================
    // UPDATE ORDER STATUS
    // =====================================================

    private static void updateOrderStatus(
            FoodDeliveryService service) {

        System.out.println("\n===== UPDATE ORDER STATUS =====");

        int orderId =
                readInt(
                        "Enter order ID: "
                );

        Order order =
                service.findOrder(orderId);

        if (order == null) {

            System.out.println(
                    "Order not found."
            );

            return;
        }

        System.out.println(
                "\nCurrent Status: " +
                order.getStatus()
        );

        System.out.println("\n1. Confirmed");
        System.out.println("2. Preparing");
        System.out.println("3. Out for Delivery");
        System.out.println("4. Delivered");

        int choice =
                readInt(
                        "\nSelect new status: "
                );

        switch (choice) {

            case 1:

                order.updateStatus(
                        OrderStatus.CONFIRMED
                );

                break;


            case 2:

                order.updateStatus(
                        OrderStatus.PREPARING
                );

                break;


            case 3:

                order.updateStatus(
                        OrderStatus.OUT_FOR_DELIVERY
                );

                break;


            case 4:

                order.updateStatus(
                        OrderStatus.DELIVERED
                );

                break;


            default:

                System.out.println(
                        "Invalid status."
                );
        }
    }


    // =====================================================
    // ASSIGN DELIVERY
    // =====================================================

    private static void assignDelivery(
            FoodDeliveryService service) {

        System.out.println("\n===== ASSIGN DELIVERY =====");

        int orderId =
                readInt(
                        "Enter order ID: "
                );

        Order order =
                service.findOrder(orderId);

        if (order == null) {

            System.out.println(
                    "Order not found."
            );

            return;
        }

        if (order.getStatus() == OrderStatus.CANCELLED) {

            System.out.println(
                    "Cannot assign delivery to a cancelled order."
            );

            return;
        }

        if (order.getDelivery() != null) {

            System.out.println(
                    "Delivery partner is already assigned."
            );

            return;
        }

        DeliveryPartner partner =
                new DeliveryPartner(
                        501,
                        "Arun",
                        "9123456789"
                );

        service.assignDelivery(
                order,
                partner
        );
    }


    // =====================================================
    // TRACK ORDER
    // =====================================================

    private static void trackOrder(
            FoodDeliveryService service) {

        System.out.println("\n===== TRACK ORDER =====");

        int orderId =
                readInt(
                        "Enter order ID: "
                );

        Order order =
                service.findOrder(orderId);

        if (order == null) {

            System.out.println(
                    "Order not found."
            );

            return;
        }

        order.displayOrder();

        if (order.getDelivery() != null) {

            order.getDelivery()
                    .displayDelivery();

        } else {

            System.out.println(
                    "\nDelivery partner has not been assigned yet."
            );
        }
    }


    // =====================================================
    // CANCEL ORDER
    // =====================================================

    private static void cancelOrder(
            FoodDeliveryService service) {

        System.out.println("\n===== CANCEL ORDER =====");

        int orderId =
                readInt(
                        "Enter order ID: "
                );

        Order order =
                service.findOrder(orderId);

        if (order == null) {

            System.out.println(
                    "Order not found."
            );

            return;
        }

        order.cancelOrder();
    }


    // =====================================================
    // INPUT VALIDATION
    // =====================================================

    private static int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Integer.parseInt(
                        scanner.nextLine().trim()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a number."
                );
            }
        }
    }


    private static String readString(String message) {

        System.out.print(message);

        return scanner.nextLine().trim();
    }
}
