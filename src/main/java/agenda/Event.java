package agenda;

import java.time.*;

public class Event {

    /**
     * The myTitle of this event
     */
    private String myTitle;
    
    /**
     * The starting time of the event
     */
    private LocalDateTime myStart;

    /**
     * The durarion of the event 
     */
    private Duration myDuration;


    /**
     * Constructs an event
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     */
    public Event(String title, LocalDateTime start, Duration duration) {
        this.myTitle = title;
        this.myStart = start;
        this.myDuration = duration;
    }

    /**
     * Tests if an event occurs on a given day
     *
     * @param aDay the day to test
     * @return true if the event occurs on that day, false otherwise
     */
    public boolean isInDay(LocalDate aDay) {
        LocalDateTime myEnd = myStart.plus(myDuration);

        if (myStart.toLocalDate().isBefore(aDay) || myStart.toLocalDate().isEqual(aDay)) {
            if (myEnd.toLocalDate().isAfter(aDay) || myEnd.toLocalDate().isEqual(aDay)) {
                return true;
            }
            else{
            return false;
            }
        }
        else{
            return false;
        }
    }
   
    /**
     * @return the myTitle
     */
    public String getTitle() {
        return myTitle;
    }

    /**
     * @return the myStart
     */
    public LocalDateTime getStart() {
        return myStart;
    }


    /**
     * @return the myDuration
     */
    public Duration getDuration() {
        return myDuration;
    }
    
    @Override
    public String toString() {
        return "Titre : " + this.myTitle + " Commence à " + this.myStart + " dure " + this.myDuration + " et se finit à " + this.myStart.plus(myDuration);
    }
}