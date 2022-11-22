package fr.timeuh.mastermind.view;

import fr.timeuh.mastermind.model.Circle;
import fr.timeuh.mastermind.model.Model;
import fr.timeuh.mastermind.model.Row;
import fr.timeuh.mastermind.model.Subject;
import javafx.scene.layout.GridPane;

/**
 * View for seeing if the player's answer is correct or not
 */
public class AnswerView extends GridPane implements Observer{
    private final int GRID_WIDTH = 100;
    private final int GRID_HEIGHT = 300;
    private final int CIRCLE_RADIUS = 10;

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

    /**
     * Update the view with the model data
     * @param subject the subject they are watching
     */
    @Override
    public void update(Subject subject) {
        if (subject instanceof Model model){
            getChildren().clear();
            int lig = 7;
            int col = 0;

            for (Row row : model.getAnswerRows()){
                for (Circle modelCircle : row.getCircles()){
                    javafx.scene.shape.Circle circle = new javafx.scene.shape.Circle(CIRCLE_RADIUS, modelCircle.getColorFromString());
                    add(circle, col, lig);
                    col ++;
                }
                lig --;
            }
        }
    }
}
