package fr.timeuh.mastermind.controller;

import fr.timeuh.mastermind.model.DifficultyBeginner;
import fr.timeuh.mastermind.model.DifficultyPro;
import fr.timeuh.mastermind.model.Model;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControlMenu implements EventHandler<ActionEvent> {

    private Model model;

    public ControlMenu(Model model) {
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getTarget() instanceof Button button){
            switch (button.getText()){
                case "Start" -> model.setPhase("PLAYING");
                case "Reset" -> model.reset();
                case "Beginner" -> model.setDifficulty(new DifficultyBeginner());
                case "Pro" -> model.setDifficulty(new DifficultyPro());
                case "Validate" -> {
                    if (model.getCurrentPon() == 4) model.checkAnswer();
                }
                case "Day/Nigth mode" -> model.switchBackground();
            }
            model.notifyObservers();
        }
    }
}
