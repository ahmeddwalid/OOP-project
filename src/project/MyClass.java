package project;

import javax.swing.JOptionPane;
import java.util.Date;

public class MyClass {

    public static void main(String[] args) {
        String purchase;
        PaymentMethod PaymentMethod;   // polymorphism 
        ShoppingCart cart = new ShoppingCart();
        do {
            String name = JOptionPane.showInputDialog("Please, select a product:\n-   Pizza, $40 \n-   Cheeseburger, $20\n-   Coffee, $5\n-   Soda, $4\n-   Water, $2\n" + "\nEnter item’s name ");
            double price = Double.parseDouble(JOptionPane.showInputDialog("Please, select a product:\n-   Pizza, $40 \n-   Cheeseburger, $20\n-   Coffee, $5\n-   Soda, $4\n-   Water, $2\n" + "\nEnter item’s Price "));
            int quantity = Integer.parseInt(JOptionPane.showInputDialog("Please, select a product:\n-   Pizza, $40 \n-   Cheeseburger, $20\n-   Coffee, $5\n-   Soda, $4\n-   Water, $2\n" + "\nEnter item’s Quantity "));

            Item item = new Item(name, quantity, price);
            cart.add(item);
            String discountInput = JOptionPane.showInputDialog("Do you have discount? (Y/N)");
            if (discountInput.equals("Y") || discountInput.equals("y")) {
                int discountAmount = Integer.parseInt(JOptionPane.showInputDialog("Enter Discount Percentage"));
                item.setPrice(price, discountAmount);
            }
            purchase = JOptionPane.showInputDialog("Proceed to checkout (Y/N)");
        } while (purchase.equals("N") || purchase.equals("n"));
        String choice = JOptionPane.showInputDialog("choose a payment method (PayPal or CreditCard)");
        if (choice.equals("Paypal") || choice.equals("paypal") || choice.equals("PayPal")) {
            String email = JOptionPane.showInputDialog("Enter Email ");
            String Password = JOptionPane.showInputDialog("Enter Password ");
            int balance = Integer.parseInt(JOptionPane.showInputDialog("Enter Balance"));
            PaymentMethod = new PayPal(email, Password);                //polymorphism
            ((PayPal) PaymentMethod).setBalance(balance);
            if (PaymentMethod.isValid()) {
                JOptionPane.showMessageDialog(null, "Valid", "PaymentMethod", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "InValid", "PaymentMethod", JOptionPane.INFORMATION_MESSAGE);
            }

        } else {
            String name = JOptionPane.showInputDialog("Enter cardName ");
            String cardNumber = JOptionPane.showInputDialog("Enter cardNumber ");
            int cvv = Integer.parseInt(JOptionPane.showInputDialog("Enter cvv"));
            int year = Integer.parseInt(JOptionPane.showInputDialog("Enter expiryDate (year)"));
            int month = Integer.parseInt(JOptionPane.showInputDialog("Enter expiryDate (month)"));
            int day = Integer.parseInt(JOptionPane.showInputDialog("Enter expiryDate (day)"));
            Date expiryDate = new Date(year - 1900, month - 1, day);

            int Balance = Integer.parseInt(JOptionPane.showInputDialog("Enter Balance"));

            PaymentMethod = new CreditCard(name, cardNumber, cvv, expiryDate);
            ((CreditCard) PaymentMethod).setBalance(Balance);
            if (PaymentMethod.isValid()) {
                JOptionPane.showMessageDialog(null, "Valid", "PaymentMethod", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "InValid", "PaymentMethod", JOptionPane.INFORMATION_MESSAGE);
            }

        }
        JOptionPane.showMessageDialog(null, cart.checkout(PaymentMethod), "CheckOut", JOptionPane.INFORMATION_MESSAGE);

        String display = JOptionPane.showInputDialog("DO you want to see what's in your cart? (Y/N)");
        if (display.equals("Y") || display.equals("y")) {
            cart.display();
        }

    }

}