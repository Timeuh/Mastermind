package fr.timeuh.mastermind.model;

import fr.timeuh.mastermind.view.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Model for the application
 */
public class Model implements Subject{

    private List<Observer> observers;
    private List<Row> rows;
    private Row answer;
    private int currentRow;
    private Difficulty difficulty;

    /**
     * Constructs a new model
     */
    public Model() {
        this.observers = new ArrayList<>();
        this.rows = new ArrayList<>();
        this.currentRow = 0;
        this.difficulty = new DifficultyBeginner();
        fillRows();
    }

    /**
     * Check player's current answer with the difficulty check
     * @return a correction row
     */
    private Row checkAnswer(){
        return difficulty.correctPlayerAnswer(answer, rows.get(currentRow));
    }

    /**
     * Generate an answer row
     * @return the answer row
     */
    private Row generateAnswer(){
        Random generator = new Random();
        List<String> colors = new ArrayList<>();

        //generate 5 random colors for circles and add them to the list
        for (int i = 0; i < 5; i++){
            int color = generator.nextInt(5);
            String realColor = getColor(color);
            colors.add(realColor);
        }

        //return a new row generated with the color list
        return new Row(colors);
    }

    /**
     * Get a color string from its int code
     * @param color the color code
     * @return the string value of the color
     */
    private String getColor(int color){
        switch (color){
            case 0 -> {return "Red";}
            case 1 -> {return "Green";}
            case 2 -> {return "Blue";}
            case 3 -> {return "Yellow";}
            case 4 -> {return "Brown";}
            default -> {return "Gray";}
        }
    }

    /**
     * Fill the row list with 7 new rows
     */
    private void fillRows(){
        for (int i = 0; i < 7; i++) rows.add(new Row());
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
