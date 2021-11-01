package InterviewQuestions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Cato {

    int minutes = 0;
    Map<Integer, List<EventData>> scheduledEvents = new HashMap<>();

    //Is triggered every minute 12:00, 12:01, 12:02, 12:03...
    public void handle(List<Event> events) {

        minutes ++;

        //handle new events
        for (Event e : events){
            if (!saveEvent(e)){
                EventData ed = new EventData(e);
                addEventDataToScheduled((minutes + (2 * ed.retry))%60, ed);
            }
        }

        //handle scheduled events
        List<EventData> sed = scheduledEvents.get(minutes % 60);
        if (sed != null) {
            for (EventData ed : sed) {
                if (!saveEvent(ed.event)) {
                    ed.increaseRetry();
                    if (ed.shouldHandle()) {
                        addEventDataToScheduled((minutes + (2 * ed.retry)) % 60, ed);
                    }
                }
            }
            scheduledEvents.put(minutes % 60, new LinkedList<>()); //clean current list of events
        }

    }

    private void addEventDataToScheduled(int timeSlot, EventData ed) {
        if (!scheduledEvents.containsKey(timeSlot)) {
            scheduledEvents.put(timeSlot, new LinkedList<>());
        }
        scheduledEvents.get(timeSlot).add(ed);
    }


    //saves the event but can fail
    private boolean saveEvent(Event event) {
        return false;
    }

    private class EventData {
        Event event;
        int retry; //0-4

        public EventData(Event event) {
            this.event = event;
            this.retry = 1;
        }

        public void increaseRetry(){
            this.retry++;
        }

        public boolean shouldHandle(){
            return this.retry < 4;
        }
    }

    interface Event{};

}
