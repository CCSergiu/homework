package week5;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SamsungGalaxyNote9 extends Samsung {
    private int phoneBattery;

    public SamsungGalaxyNote9() {
        phoneBattery = BATTERY_LIFE;
    }

    @Override
    public int getPhoneBattery() {
        return phoneBattery;
    }

    public void setPhoneBattery(int phoneBattery) {
        this.phoneBattery = phoneBattery;
    }

    @Override
    public MessageHistory listMessages(String number) {
        if (messageHistory == null || messageHistory.isEmpty()) {
            return null;
        }
        messageHistory.listMessages(number);
        return messageHistory;
    }

    @Override
    public CallHistory listCalls(String number) {
        if (callHistory == null || callHistory.isEmpty()) {
            return null;
        }
        callHistory.listCalls(number);
        return callHistory;
    }

    @Override
    public boolean sendMessage(String number, String message) {
        if (messageHistory == null)
            messageHistory = new MessageHistory();
        if (checkBatteryLife(true)) {
            messageHistory.addEvent(number, message);
            updateBattery(1);
            return true;
        }
        return false;
    }

    @Override
    public boolean makeCall(String number) {
        if (callHistory == null)
            callHistory = new CallHistory();
        if (checkBatteryLife(false)) {
            callHistory.addEvent(number, new Date());
            updateBattery(2);
            return true;
        }
        return false;
    }

    @Override
    public boolean addContact(String phoneNumber, String firstName, String lastName) {
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setNumber(phoneNumber);
        if (this.contacts == null)
            this.contacts = new ArrayList<Contact>();
        contacts.add(contact);
        return true;
    }

    @Override
    public List<Contact> listContacts() {
        if (this.contacts == null) {
            return null;
        }
        for (Contact c : this.contacts) {
            System.out.println(c);
        }
        return contacts;
    }

    @Override
    public boolean viewHistory() {
        return false;
    }

    boolean checkBatteryLife(boolean isMessage) {
        if (isMessage) {
            if (phoneBattery > 1) {
                return true;
            }
        } else {
            if (phoneBattery > 2) {
                return true;
            }
        }
        return false;
    }

    public void updateBattery(int value) {
        phoneBattery -= value;
    }
}
