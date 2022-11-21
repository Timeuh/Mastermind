package fr.timeuh.mastermind.model;

import fr.timeuh.mastermind.view.Observer;

public interface Subject {

    public void addObserver(Observer obs);

    public void delObserver(Observer obs);

    public void notifyObservers();
}
