package fr.timeuh.mastermind.model;

import fr.timeuh.mastermind.view.Observer;

/**
 * A subject updates its observers to display real time information
 */
public interface Subject {

    /**
     * Add an observer to the subject's list
     * @param obs the observer to add
     */
    public void addObserver(Observer obs);

    /**
     * Remove an observer from the subject's list
     * @param obs the observer to remove
     */
    public void delObserver(Observer obs);

    /**
     * Notify all the observers of the subject's list, so they can update their content
     */
    public void notifyObservers();
}
