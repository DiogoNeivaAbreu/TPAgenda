package agenda;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


/**
 * Description : An agenda that stores events
 */
public class Agenda {
    
    public List<Event> myEvents = new ArrayList<>();
    public List<Event> myEventsDay = new ArrayList<>();
    public List<Event> myEventTitle = new ArrayList<>(); 
    
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
    
     /**
     * Trouver les événements de l'agenda en fonction de leur titre
     * @param title le titre à rechercher
     * @return les événements qui ont le même titre
     */
    public List<Event> findByTitle(String title) {
        // TODO : implémenter cette méthode
        for(Event e:myEvents){
            if(e.getTitle().equals(title)){
                myEventTitle.add(e);
            }
        }
        return myEventTitle;
    }
    
    /**
     * Déterminer s’il y a de la place dans l'agenda pour un événement
     * @param e L'événement à tester (on se limitera aux événements simples)
     * @return vrai s’il y a de la place dans l'agenda pour cet événement
     */
    public boolean isFreeFor(Event e) {
        // TODO : implémenter cette méthode
        for(Event evenement:myEvents){
            if(e.getStart().isAfter(evenement.getStart()))
                return false;
        }
        return true;
    }
}
