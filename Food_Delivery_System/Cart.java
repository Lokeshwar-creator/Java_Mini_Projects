import java.util.ArrayList;

public class Cart {

    private ArrayList<Fooditem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addItem(Fooditem item) {

        items.add(item);

        System.out.println(
                item.getName() +
                " added to cart."
        );
    }

    public void removeItem(int itemId) {

        for (Fooditem item : items) {

            if (item.getItemId() == itemId) {

                items.remove(item);

                System.out.println(
                        item.getName() +
                        " removed from cart."
                );

                return;
            }
        }

        System.out.println("Item not found in cart.");
    }

    public double calculateTotal() {

        double total = 0;

        for (Fooditem item : items) {
            total += item.getPrice();
        }

        return total;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public ArrayList<Fooditem> getItems() {
        return items;
    }

    public void clearCart() {
        items.clear();
    }

    public void displayCart() {

        if (items.isEmpty()) {
            System.out.println("\nCart is empty.");
            return;
        }

        System.out.println("\n========== CART ==========");

        for (Fooditem item : items) {
            item.displayItem();
        }

        System.out.println("--------------------------");
        System.out.println("Total: ₹" + calculateTotal());
    }
}