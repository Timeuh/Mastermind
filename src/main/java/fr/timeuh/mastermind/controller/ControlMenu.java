package fr.timeuh.mastermind.controller;

import fr.timeuh.mastermind.model.Circle;
import fr.timeuh.mastermind.model.DifficultyBeginner;
import fr.timeuh.mastermind.model.DifficultyPro;
import fr.timeuh.mastermind.model.Model;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Control the menu buttons
 */
public class ControlMenu implements EventHandler<ActionEvent> {

    private Model model;

    /**
     * Constructs a new menu controller
     * @param model the model of the game
     */
    public ControlMenu(Model model) {
        this.model = model;
    }

    /**
     * Manages the action event
     * @param event the event which occurred
     */
    @Override
    public void handle(ActionEvent event) {
        if (event.getTarget() instanceof Button button){
            switch (button.getText()){
                case "Start" -> model.setPhase("PLAYING");
                case "Reset" -> model.reset();
                case "Beginner" -> model.setDifficulty(new DifficultyBeginner());
                case "Pro" -> model.setDifficulty(new DifficultyPro());
                case "Validate" -> {
                    if (model.getPhase().equals("PLAYING")){
                        boolean presence = false;
                        for (Circle modelCircle : model.getPlayerRows().get(model.getCurrentRow()-1).getCircles()){
                            if (modelCircle.getColor().equals("SILVER")) presence = true;
                        }
                        if (!presence) model.checkAnswer();
                    }
                }
                case "Day/Nigth mode" -> model.switchBackground();
            }
            model.notifyObservers();
        }
    }
}
