package week3.trei;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pos {

    List<BankAccount> bankAccountList;

    public List<BankAccount> getBankAccountList() {
        return bankAccountList;
    }

    public void setBankAccountList(List<BankAccount> bankAccountList) {
        this.bankAccountList = bankAccountList;
    }

    public boolean addKnownBankAccount(BankAccount bankAccountToAdd) {

        if (bankAccountList == null) {
            bankAccountList = new ArrayList<BankAccount>();
        }
        return bankAccountList.add(bankAccountToAdd);
    }

    public String pay(Float amount, Card cardToMakePayment) {

        boolean check = false;
        for (BankAccount element : bankAccountList) {

            if (element.cardNumbers.contains(cardToMakePayment.cardNumber)) {
                if (cardToMakePayment.expirationDate.after(new Date())) {
                    check = true;
                }
            }

            if (check) {
                if (element.balance >= amount) {
                    element.withdrawMoney(amount);
                    return "tranzactia a fost facuta";
                } else {
                    return "sold indispobil";
                }
            }
        }

        return "card indisponibil";
    }
}