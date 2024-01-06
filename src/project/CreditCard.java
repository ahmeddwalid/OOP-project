package project;

import java.util.Date;

public class CreditCard implements PaymentMethod {

    private String cardName, cardNumber;
    private int cvv, balance;
    private Date expiryDate;

    CreditCard(String cardName, String cardNumber, int cvv, Date expiryDate) {
        balance = 0;
        this.cvv = cvv;
        this.cardName = cardName;
        this.expiryDate = expiryDate;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isValid() {
        Date CurrentDate = new Date();
        return expiryDate.after(CurrentDate);
    }

    public String pay(int amount) {
        if (isValid() && balance >= amount) {

            balance -= amount;

            return "Successful Remaining balance = " + balance;
        } else {
            return "failed";
        }
    }
}
