package week3.trei;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    String iban;
    Float balance;
    List<String> cardNumbers;

    BankAccount(String iban) {
        this.iban = iban;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public List<String> getCardNumbers() {
        return cardNumbers;
    }

    public void setCardNumbers(List<String> cardNumbers) {
        this.cardNumbers = cardNumbers;
    }

    public void addMoney(Float amount) {
        this.balance += amount;
    }

    public void withdrawMoney(Float amount) {
        this.balance -= amount;
    }

    public boolean attachCard(String cardToAttach) {

        if (cardNumbers == null) {
            cardNumbers = new ArrayList<String>();
        }
        return cardNumbers.add(cardToAttach);

    }

}
