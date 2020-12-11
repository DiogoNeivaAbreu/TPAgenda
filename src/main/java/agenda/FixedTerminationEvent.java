package agenda;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive event that terminates after a given date, or after
 * a given number of occurrences
 */
public class FixedTerminationEvent extends RepetitiveEvent {

    public LocalDate terminationInclusive;
    public long numberOfOccurrences;
    /**
     * Constructs a fixed terminationInclusive event ending at a given date
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     * @param terminationInclusive the date when this event ends
     */
    public FixedTerminationEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency, LocalDate terminationInclusive) {
         super(title, start, duration, frequency);
        // TODO : implémenter cette méthode
        this.terminationInclusive = terminationInclusive;

    }

    /**
     * Constructs a fixed termination event ending after a number of iterations
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     * @param numberOfOccurrences the number of occurrences of this repetitive event
     */
    public FixedTerminationEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency, long numberOfOccurrences) {
        super(title, start, duration, frequency);
        // TODO : implémenter cette méthode
        this.numberOfOccurrences = numberOfOccurrences;
    }

    /**
     *
     * @return the termination date of this repetitive event
     */
    public LocalDate getTerminationDate() {
        // TODO : implémenter cette méthode
        return terminationInclusive;
    }

    public long getNumberOfOccurrences() {
        // TODO : implémenter cette méthode
        return this.numberOfOccurrences;
    }
    
     public void addExecption(LocalDate date) {
        lesExceptions.add(date);
    }

    public boolean isInDay(LocalDate aDay) {
        LocalDateTime start = this.getStart();
        Duration duration = this.getDuration();
        LocalDateTime myEnd = start.plus(duration);

        boolean r = false;

        for (LocalDate d : lesExceptions) {
            if (d.isEqual(aDay)) {
                return false;
            }

            if (start.toLocalDate().isEqual(aDay)) {
                return true;
            }

            if (this.terminationInclusive != null) {
                if ((start.plus(numberOfOccurrences)).LocalDate().isAfter(aDay) || (start.plus(numberOfOccurrences)).LocalDate().isEqual(aDay)) {

                    while (start.toLocalDate().isBefore(aDay)) {
                        myEnd = start.plus(duration);
                        if (start.toLocalDate().isBefore(aDay) || start.toLocalDate().isEqual(aDay)) {
                            if (myEnd.toLocalDate().isAfter(aDay) || myEnd.toLocalDate().isEqual(aDay)) {
                                return true;
                            }

                        }
                        start = start.plus(1, frequency);
                    }
                }
            } else {
                if (start.plus(this.numberOfOccurrences, this.frequency).toLocalDate().isAfter(aDay) || start.plus(this.numberOfOccurrences, this.frequency).toLocalDate().isEqual(aDay));
                while (start.toLocalDate().isBefore(aDay) || start.toLocalDate().isEqual(aDay)) {
                    if (start.toLocalDate().isBefore(aDay) || start.toLocalDate().isEqual(aDay)) {
                        if (myEnd.toLocalDate().isAfter(aDay) || myEnd.toLocalDate().isEqual(aDay)) {
                            return true;
                        }
                    }
                }

                return r;

            }
        }
        
}
