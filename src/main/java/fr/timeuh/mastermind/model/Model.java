package fr.timeuh.mastermind.model;

import fr.timeuh.mastermind.view.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Model for the application
 */
public class Model implements Subject{

    private List<Observer> observers;
    private List<Row> rows;
    private int currentRow;

    /**
     * Constructs a new model
     */
    public Model() {
        this.observers = new ArrayList<>();
        this.rows = new ArrayList<>();
        this.currentRow = 0;
    }

    /**
     * Add an observer to the model's list
     * @param obs the observer to add
     */
    @Override
    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    /**
     * Remove an observer from the model's list
     * @param obs the observer to remove
     */
    @Override
    public void delObserver(Observer obs) {
        observers.remove(obs);
    }

    /**
     * Notify all observers, so they can update their content
     */
    @Override
    public void notifyObservers() {
        for (Observer obs : observers) obs.update(this);
    }
}
