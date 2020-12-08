package agenda;

import java.time.LocalDate;
import java.util.*;


/**
 * Description : An agenda that stores events
 */
public class Agenda {
    
    public List<Event> myEvents = new ArrayList<>();
    public List<Event> myEventsDay = new ArrayList<>();
    
    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */
    public void addEvent(Event e) {
        // TODO : implémenter cette méthode
        myEvents.add(e);
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return and iteraror to the events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        // TODO : implémenter cette méthode
        for (Event e : myEvents){
            if (e.isInDay(day)){
                myEventsDay.add(e);
            }
        }
        return myEventsDay;
    }
}
