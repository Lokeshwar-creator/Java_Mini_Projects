import java.util.ArrayList;

public class Restaurant {

    private int restaurantId;
    private String name;
    private String address;

    private ArrayList<Fooditem> menu;

    public Restaurant(int restaurantId, String name, String address) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.address = address;
        this.menu = new ArrayList<>();
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<Fooditem> getMenu() {
        return menu;
    }

    public void addFoodItem(Fooditem item) {
        menu.add(item);
    }

    public void displayMenu() {

        System.out.println("\n===== " + name + " MENU =====");

        if (menu.isEmpty()) {
            System.out.println("No food items available.");
            return;
        }

        for (Fooditem item : menu) {
            item.displayItem();
        }
    }

    public void displayRestaurant() {

        System.out.println(
                restaurantId + " | " +
                name + " | " +
                address
        );
    }
}