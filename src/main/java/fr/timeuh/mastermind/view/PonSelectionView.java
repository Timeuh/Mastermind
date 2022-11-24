package fr.timeuh.mastermind.view;

import fr.timeuh.mastermind.model.Model;
import fr.timeuh.mastermind.model.Row;
import fr.timeuh.mastermind.model.Subject;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

/**
 * Pon selection view for the player
 */
public class PonSelectionView extends GridPane implements Observer{
    private final int GRID_SPACING = 10;
    private final int GRID_HGAP = 5;
    private final int CIRCLE_RADIUS = 20;
    private final int MINI_CIRCLE_RADIUS = 10;
    private final int FONT_SIZE = 20;

    /**
     * Constructs a new pon selection view
     */
    public PonSelectionView() {
        init();
    }

    /**
     * Initialize the view
     */
    private void init(){
        for (int y = 0; y < 5; y++){
            Circle grey = new Circle(CIRCLE_RADIUS, Color.BLACK);
            grey.setStroke(Color.GREY);
            add(grey, y, 0);
        }

        for (int i = 1; i < 8; i++){
            for (int x = 0; x < 5; x++){
                Circle grey = new Circle(CIRCLE_RADIUS, Color.SILVER);
                if ((i == 7) && (x == 0)) grey.setStroke(Color.CHARTREUSE);
                else grey.setStroke(Color.BLACK);
                add(grey, x, i);
            }
        }

        Label difficulty = new Label("Difficulty : Beginner");
        difficulty.setFont(new Font(FONT_SIZE));
        add(difficulty, 8,0);

        setHgap(GRID_HGAP);
        setVgap(GRID_SPACING);
        setPadding(new Insets(GRID_SPACING));
    }

    /**
     * Update the view with the model data
     * @param subject the subject they are watching
     */
    @Override
    public void update(Subject subject) {
        if (subject instanceof Model model){
            getChildren().clear();

            //display answer row
            if (model.getPhase().equals("OVER")){
                //if the game is over, display the answer
                int col = 0;
                for (fr.timeuh.mastermind.model.Circle modelCircle : model.getAnswer().getCircles()){
                    Circle grey = new Circle(CIRCLE_RADIUS, modelCircle.getColorFromString());
                    grey.setStroke(Color.GREY);
                    add(grey, col, 0);
                    col ++;
                }
            } else {
                //display hidden answer
                for (int y = 0; y < 5; y++){
                    Circle black = new Circle(CIRCLE_RADIUS, Color.BLACK);
                    black.setStroke(Color.GREY);
                    add(black, y, 0);
                }
            }

            //display player pon rows
            int lig = 1;
            for (Row row : model.getPlayerRows()){
                int col = 0;
                for (fr.timeuh.mastermind.model.Circle modelCircle : row.getCircles()){
                    Circle grey = new Circle(CIRCLE_RADIUS, modelCircle.getColorFromString());
                    grey.setStroke(Color.BLACK);
                    if ((lig == model.getCurrentRow()) && (col == model.getCurrentPon())) grey.setStroke(Color.CHARTREUSE);
                    add(grey, col, lig);
                    col++;
                }
                lig ++;
            }

            //display correction of player's answer row
            lig = 7;
            for (Row row : model.getAnswerRows()){
                int col = 8;
                for (fr.timeuh.mastermind.model.Circle modelCircle : row.getCircles()){
                    javafx.scene.shape.Circle circle = new javafx.scene.shape.Circle(MINI_CIRCLE_RADIUS, modelCircle.getColorFromString());
                    circle.setStroke(Color.BLACK);
                    add(circle, col, lig);
                    col ++;
                }
                lig --;
            }

            Label difficulty = new Label("Difficulty : " + model.currentDifficulty());
            difficulty.setFont(new Font(FONT_SIZE));
            add(difficulty, 8,0);
        }
    }
}
