package fr.timeuh.mastermind.model;

import fr.timeuh.mastermind.view.Observer;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * Model for the application
 */
public class Model implements Subject{

    private List<Observer> observers;
    private List<Row> playerRows;
    private List<Row> answerRows;
    private Row answer;
    private Difficulty difficulty;
    private Color background;
    private int currentRow;
    private int currentPon;
    private String phase;

    /**
     * Constructs a new model
     */
    public Model() {
        this.observers = new ArrayList<>();
        this.playerRows = new ArrayList<>();
        this.answerRows = new ArrayList<>();
        this.difficulty = new DifficultyBeginner();
        this.background = Color.WHITE;
        this.currentRow = 7;
        this.currentPon = 0;
        this.answer = generateAnswer();
        this.phase = "WAITING";
        fillRows();
    }

    /**
     * Check player's current answer with the difficulty check and add the row to the correction
     */
    public void checkAnswer(){
        Row verif = difficulty.correctPlayerAnswer(answer, playerRows.get(currentRow-1));
        answerRows.add(verif);
        currentRow --;
        currentPon = 0;

        boolean end = true;
        for (Circle circle : verif.getCircles()){
            if (!circle.getColor().equals("BLACK")) {
                end = false;
                break;
            }
        }
        if (currentRow == 0) end = true;
        if (end) phase = "OVER";
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
            case 0 -> {return "CRIMSON";}
            case 1 -> {return "GREEN";}
            case 2 -> {return "NAVY";}
            case 3 -> {return "GOLD";}
            case 4 -> {return "SADDLEBROWN";}
            default -> {return "GREY";}
        }
    }

    /**
     * Fill the row list with 7 new rows
     */
    private void fillRows(){
        for (int i = 0; i < 7; i++) playerRows.add(new Row());
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

    /**
     * Get the current difficulty of the game
     * @return a string representing the difficulty
     */
    public String currentDifficulty(){
        if (difficulty instanceof DifficultyPro) return "Pro";
        else return "Beginner";
    }

    /**
     * Reset the game, except the observers
     */
    public void reset(){
        this.playerRows = new ArrayList<>();
        this.answerRows = new ArrayList<>();
        this.difficulty = new DifficultyBeginner();
        this.background = Color.WHITE;
        this.currentRow = 7;
        this.currentPon = 0;
        this.answer = generateAnswer();
        this.phase = "WAITING";
        fillRows();
    }

    /**
     * Change current background color
     */
    public void switchBackground(){
        if (background.equals(Color.WHITE)) background = Color.GREY;
        else if (background.equals(Color.GREY)) background = Color.WHITE;
    }


    /**
     * Change current pon color
     * @param color the new color
     */
    public void changePonColor(String color){
        if (currentPon != 8) {
            Row current = playerRows.get(currentRow - 1);
            Circle circle = current.getCircles().get(currentPon);
            circle.setColor(color);
        }
    }

    /**
     * Change game difficulty
     * @param difficulty the new difficulty
     */
    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Change the game phase
     * @param phase the new game phase
     */
    public void setPhase(String phase) {
        this.phase = phase;
    }

    /**
     * @return the current background color
     */
    public Color getBackground() {
        return background;
    }

    /**
     * @return the current row of player's pon
     */
    public int getCurrentRow() {
        return currentRow;
    }

    /**
     * @return the current player's pon
     */
    public int getCurrentPon() {
        return currentPon;
    }

    /**
     * @return the answer row list
     */
    public List<Row> getAnswerRows() {
        return answerRows;
    }

    /**
     * @return the list of player's rows
     */
    public List<Row> getPlayerRows() {
        return playerRows;
    }

    /**
     * @return the current game phase
     */
    public String getPhase() {
        return phase;
    }

    /**
     * @return the answer row
     */
    public Row getAnswer() {
        return answer;
    }

    /**
     * Change the current row
     * @param currentRow the new current row
     */
    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    /**
     * Change the current pon
     * @param currentPon the new current pon
     */
    public void setCurrentPon(int currentPon) {
        this.currentPon = currentPon;
    }
}
