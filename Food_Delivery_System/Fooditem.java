public class Fooditem {

    private int itemId;
    private String name;
    private double price;
    private String category;

    public Fooditem(int itemId, String name, double price, String category) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public void displayItem() {
        System.out.println(
                itemId + " | " +
                name + " | " +
                "Rs." + price + " | " +
                category
        );
    }
}