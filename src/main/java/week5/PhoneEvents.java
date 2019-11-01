package week5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PhoneEvents<T> {
    private HashMap<String, LinkedList<T>> events;
    private List<String> eventsOrder;

    public boolean addEvent(String number, T eventDetails) {
        if (eventDetails instanceof String)
            if (((String) eventDetails).length() > 500) {
                return false;
            }
        if (events == null || events.isEmpty()) {
            events = new HashMap<>();
            eventsOrder = new ArrayList<>();
        }
        if (events.get(number) == null) {
            LinkedList<T> messageList = new LinkedList<>();
            messageList.add(eventDetails);
            events.put(number, messageList);
            eventsOrder.add(number);
        } else {
            events.get(number).add(eventDetails);
            //update order: move last
            int index = eventsOrder.indexOf(number);
            eventsOrder.remove(index);
            eventsOrder.add(number);
        }
        return true;
    }

    LinkedList<T> getEventsForNumber(String number) {
        if (events == null || events.isEmpty() || !events.containsKey(number)) {
            return null;
        }
        return events.get(number);
    }

    int getNoOfEventsForNumber(String number) {
        if (events == null || events.isEmpty() || !events.containsKey(number)) {
            return 0;
        }
        return events.get(number).size();
    }

    public HashMap<String, LinkedList<T>> getEvents() {
        return events;
    }

    public void setEvents(HashMap<String, LinkedList<T>> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "PhoneEvents{" +
                "events=" + events +
                '}';
    }

    public boolean isEmpty() {
        return events == null || events.size() == 0;
    }
}
