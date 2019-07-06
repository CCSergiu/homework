package Week3_June1.Trei;

import java.util.ArrayList;
import java.util.List;

public class User {

    List<BankAccount> bankAccountList;
    List<Card> cardList;

    public List<BankAccount> getBankAccountList() {
        return bankAccountList;
    }

    public void setBankAccountList(List<BankAccount> bankAccountList) {
        this.bankAccountList = bankAccountList;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    public boolean addCard(Card cardToAdd) {

        if (cardList == null) {
            cardList = new ArrayList<Card>();
        }
        return cardList.add(cardToAdd);

    }

    public boolean addBankAccount(BankAccount bankAccountToAdd) {

        if (bankAccountList == null) {
            bankAccountList = new ArrayList<BankAccount>();
        }
        return bankAccountList.add(bankAccountToAdd);

    }

    public void printBalance() {
        for (BankAccount element : bankAccountList) {
            System.out.println(element.iban + " " + element.balance);
        }
    }
}

