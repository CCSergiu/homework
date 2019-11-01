package week5;

import java.util.LinkedList;

public class MessageHistory extends PhoneEvents<String> {
    public boolean addEvent(String number, String eventDetails) {
        return super.addEvent(number, eventDetails);
    }

    public void listMessages(String number) {
        System.out.println();
        LinkedList<String> list = super.getEventsForNumber(number);
        System.out.println("Messages for number : " + number);
        if (list == null || list.size() == 0) {
            System.out.println("No messages");
        } else {
            for (int i = list.size() - 1; i >= 0; i--) {
                System.out.println(list.get(i));
            }
        }
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }
}