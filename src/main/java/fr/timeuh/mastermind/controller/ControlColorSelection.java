package fr.timeuh.mastermind.controller;

import fr.timeuh.mastermind.model.Circle;
import fr.timeuh.mastermind.model.Model;
import fr.timeuh.mastermind.model.Row;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Controller for the color selection
 */
public class ControlColorSelection implements EventHandler<MouseEvent> {

    private Model model;

    /**
     * Constructs a new color selection controller
     * @param model the model of the game
     */
    public ControlColorSelection(Model model) {
        this.model = model;
    }

    /**
     * Manages the action event
     * @param event the event which occurred
     */
    @Override
    public void handle(MouseEvent event) {
        if (model.getPhase().equals("PLAYING")){
            if (event.getY() > 10 && event.getY() < 50){
                String color = getColor(event.getX());
                model.changePonColor(color);
                model.notifyObservers();
            }
        }
    }

    /**
     * Get the color name depending of the x coordinate
     * @param x the x coordinate
     * @return a string representing the color of the pon
     */
    private String getColor(double x){
        if (x > 145 && x < 185) return "CRIMSON";
        if (x > 195 && x < 235) return "GREEN";
        if (x > 245 && x < 285) return "NAVY";
        if (x > 295 && x < 335) return "GOLD";
        if (x > 345 && x < 385) return "SADDLEBROWN";
        return "SILVER";
    }
}
