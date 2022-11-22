package fr.timeuh.mastermind.controller;

import fr.timeuh.mastermind.model.Model;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Controls the pon selection
 */
public class ControlPonSelection implements EventHandler<MouseEvent> {

    private Model model;

    /**
     * Constructs a new pon selection controller
     * @param model the model of the game
     */
    public ControlPonSelection(Model model) {
        this.model = model;
    }

    /**
     * Manages the action event
     * @param event the event which occurred
     */
    @Override
    public void handle(MouseEvent event) {
        if (model.getPhase().equals("PLAYING")){
            double x = Math.round(event.getX() / 40);
            double y = Math.round(event.getY() / 55);
            System.out.println("x : " + x + ", y : " + y);
        }
    }
}
