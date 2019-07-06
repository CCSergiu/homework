package Week3_June1.Trei;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {

        User user = new User();
        BankAccount bankAccount = new BankAccount("IN1234");


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse("2021-03-30");

        Card card = new Card(date, "1234567812345678", "Ion");

        bankAccount.attachCard(card.cardNumber);
        bankAccount.setBalance(100f);

        user.addBankAccount(bankAccount);
        user.addCard(card);

        Pos pos1 = new Pos();
        pos1.addKnownBankAccount(bankAccount);

        System.out.println(pos1.pay(50f, card));
        System.out.println(pos1.pay(40f, card));
        user.printBalance();

    }
}

