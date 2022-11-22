package fr.timeuh.mastermind.view;

import javafx.scene.layout.GridPane;

/**
 * View for seeing if the player's answer is correct or not
 */
public class AnswerView extends GridPane {
    private final int GRID_WIDTH = 100;
    private final int GRID_HEIGHT = 300;

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
        setMinSize(GRID_WIDTH,GRID_HEIGHT);
    }
}
