package week5;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Phone phone = new SamsungGalaxyNote9();
        phone.addContact("0733403714", "Razvan", "Ionescu");
        phone.addContact("0733403712", "Ionut", "Costea");
        phone.listContacts();

        phone.sendMessage("0733403714", "Ce faci?");
        phone.sendMessage("0733403714", "Ce faci tu?");

        phone.listMessages("0733403714");

        phone.makeCall("0733403714");
        phone.makeCall("0733403714");

        phone.listCalls("0733403714");

        phone.viewHistory();
    }
}
