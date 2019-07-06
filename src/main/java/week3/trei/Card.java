package week3.trei;

import java.util.Date;

public class Card {

    Date expirationDate;
    String ownerName;
    String cardNumber;

    Card(Date expirationDate, String cardNumber, String ownerName) {

        this.expirationDate = expirationDate;
        this.cardNumber = cardNumber;
        this.ownerName = ownerName;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

}

