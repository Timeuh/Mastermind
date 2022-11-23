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
            int x = getModelX(event.getX());
            int y = getModelY(event.getY());
        }
    }

    /**
     * Get the x compatible with the model pon
     * @param currentX the event x
     * @return the x compatible with the model
     */
    private int getModelX(double currentX){
        if (currentX > 10 && currentX < 50) return 0;
        if (currentX > 60 && currentX < 100) return 1;
        if (currentX > 110 && currentX < 150) return 2;
        if (currentX > 160 && currentX < 200) return 3;
        if (currentX > 210 && currentX < 250) return 4;
        return 8;
    }

    /**
     * Get the y compatible with the model pon
     * @param currentY the event y
     * @return the y compatible with the model
     */
    private int getModelY(double currentY){
        if (currentY > 60 && currentY < 100) return 0;
        if (currentY > 110 && currentY < 150) return 1;
        if (currentY > 160 && currentY < 200) return 2;
        if (currentY > 210 && currentY < 250) return 3;
        if (currentY > 260 && currentY < 300) return 4;
        if (currentY > 310 && currentY < 350) return 5;
        if (currentY > 360 && currentY < 400) return 6;
        return 8;
    }
}
