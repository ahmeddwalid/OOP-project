package project;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class ShoppingCart extends Display {

    ArrayList<Item> orderItems;

    public ShoppingCart() {
        orderItems = new ArrayList<>();      // composition relationship
    }

    public void add(Item item) {
        if (orderItems.size() < 10) {
            orderItems.add(item);
        } else {
            JOptionPane.showMessageDialog(null, "Error", "Add Item", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void remove(Item item) {
        if (!orderItems.isEmpty() && orderItems.contains(item)) {
            orderItems.remove(item);
        } else {
            JOptionPane.showMessageDialog(null, "Error", "remove Item", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public double getTotalAmount() {
        double total = 0;
        for (int i = 0; i < orderItems.size(); i++) {
            total += (orderItems.get(i).getPrice()) * (orderItems.get(i).getQuantity());
        }
        return total;
    }

    public String checkout(PaymentMethod paymentMethod) {
        JOptionPane.showMessageDialog(null, "number of items in your Cart = " + Item.count + " And Your TotalAmount = " + getTotalAmount(), "Checkout", JOptionPane.INFORMATION_MESSAGE);
        return paymentMethod.pay((int) getTotalAmount());
    }

    @Override
    public void display() // Override (Abstract class)
    {
        for (int i = 0; i < orderItems.size(); i++) {

            JOptionPane.showMessageDialog(null, "item in index (" + (i + 1) + ") :\n" + "item’s name:" + orderItems.get(i).getName() + "\n" + "item’s price :" + orderItems.get(i).getPrice() + "\n" + "item’s Quantity :" + orderItems.get(i).getQuantity(), "Display", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
