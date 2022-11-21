package fr.timeuh.mastermind.model;

import fr.timeuh.mastermind.view.Observer;

import java.util.ArrayList;
import java.util.List;

public class Model implements Subject{

    private List<Observer> observers;

    public Model() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void delObserver(Observer obs) {
        observers.remove(obs);
    }

    @Override
    public void notifyObservers() {
        for (Observer obs : observers) obs.update(this);
    }
}
