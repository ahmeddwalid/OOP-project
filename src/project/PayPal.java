package project;

import java.util.regex.*;
import javax.swing.JOptionPane;

public class PayPal implements PaymentMethod {

    private String email, password;
    private int balance;

    PayPal(String email, String password) {
        this.email = email;
        this.password = password;
        balance = 0;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean isValid() {
        //email
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher emailMatcher = emailPattern.matcher(email);

        //password
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        Pattern passwordPattern = Pattern.compile(passwordRegex);
        Matcher passwordMatcher = passwordPattern.matcher(password);

        return (emailMatcher.matches() && passwordMatcher.matches());
    }

    @Override
    public String pay(int amount) {
        if (isValid() && amount <= balance) {
            balance -= amount;
            return "Successful Remaining balance = " + balance;
        } else {
            return "failed";
        }

    }
}
