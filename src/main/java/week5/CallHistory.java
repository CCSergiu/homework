package week5;

import java.util.Date;
import java.util.LinkedList;

public class CallHistory extends PhoneEvents<Date> {
    public boolean addEvent(String number, Date eventDetails) {
        return super.addEvent(number, eventDetails);
    }

    public void listCalls(String number) {
        System.out.println();
        LinkedList<Date> list = super.getEventsForNumber(number);
        System.out.println("Calls for number : " + number);
        if (list == null || list.size() == 0) {
            System.out.println("No calls");
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