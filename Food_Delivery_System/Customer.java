public class Customer {

    private int customerId;
    private String name;
    private String phone;
    private String address;

    private Cart cart;

    public Customer(
            int customerId,
            String name,
            String phone,
            String address) {

        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.address = address;

        this.cart = new Cart();
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public Cart getCart() {
        return cart;
    }

    public void addToCart(Fooditem item) {
        cart.addItem(item);
    }

    public void removeFromCart(int itemId) {
        cart.removeItem(itemId);
    }

    public void viewCart() {
        cart.displayCart();
    }

    public void displayCustomer() {

        System.out.println("\n===== CUSTOMER =====");

        System.out.println("ID      : " + customerId);
        System.out.println("Name    : " + name);
        System.out.println("Phone   : " + phone);
        System.out.println("Address : " + address);
    }
}