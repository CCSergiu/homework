package week5;

import java.util.List;

public interface Phone {
    int getPhoneBattery();

    MessageHistory listMessages(String number);

    CallHistory listCalls(String number);

    boolean sendMessage(String number, String message);

    boolean makeCall(String number);

    boolean addContact(String phoneNumber, String firstName, String lastName);

    List<Contact> listContacts();

    boolean viewHistory();
}
