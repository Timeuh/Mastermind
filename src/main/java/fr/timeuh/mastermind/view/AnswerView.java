package fr.timeuh.mastermind.view;

import javafx.scene.layout.GridPane;

/**
 * View for seeing if the player's answer is correct or not
 */
public class AnswerView extends GridPane {

    /**
     * Constructs a new answer view
     */
    public AnswerView() {
        init();
    }

    /**
     * Initialize the view
     */
    private void init(){
        setMinSize(200,300);
    }
}
