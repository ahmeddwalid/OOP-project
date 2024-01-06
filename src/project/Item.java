package project;

public class Item {

    private String name;
    private int quantity;
    private double price;
    public static int count = 0;

    Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPrice(double price, int discountPercent) {
        this.price = ((price * discountPercent) / 100);        // OverLoading
    }

    public double getPrice() {
        return price;
    }
}
