package agenda;

import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive Event
 */
public class RepetitiveEvent extends Event {
    
    public String title;
    public LocalDateTime start;
    public Duration duration;
    public ChronoUnit frequency;
    
    public List<Event> repetitions = new ArrayList<>();
     
    /**
     * Constructs a repetitive event
     *
     * @param title the title of this event
     * @param start the start of this event
     * @param duration myDuration in seconds
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     */
    public RepetitiveEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency) {
        super(title, start, duration);
        // TODO : implémenter cette méthode
        this.title = title;
        this.start = start;
        this.duration = duration;
        this.frequency = frequency;
        
    }

    /**
     * Adds an exception to the occurrence of this repetitive event
     *
     * @param date the event will not occur at this date
     */
    public void addException(LocalDate date) {
        // TODO : implémenter cette méthode
        ChronoUnit f = this.getFrequency();
        for (date){
            
            
        }
    }

    /**
     *
     * @return the type of repetition
     */
    public ChronoUnit getFrequency() {
        // TODO : implémenter cette méthode  
        return frequency;
    }

}
