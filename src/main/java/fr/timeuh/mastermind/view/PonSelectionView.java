package fr.timeuh.mastermind.view;

import fr.timeuh.mastermind.model.Model;
import fr.timeuh.mastermind.model.Row;
import fr.timeuh.mastermind.model.Subject;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Pon selection view for the player
 */
public class PonSelectionView extends GridPane implements Observer{
    private final int GRID_SPACING = 10;
    private final int GRID_HGAP = 5;
    private final int CIRCLE_RADIUS = 20;
    private final int MINI_CIRCLE_RADIUS = 10;

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
                if ((i == 7) && (x == 0)) grey.setStroke(Color.BLANCHEDALMOND);
                else grey.setStroke(Color.BLACK);
                add(grey, x, i);
            }
        }

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

            if (model.getPhase().equals("OVER")){
                int col = 0;
                for (fr.timeuh.mastermind.model.Circle modelCircle : model.getAnswer().getCircles()){
                    Circle grey = new Circle(CIRCLE_RADIUS, modelCircle.getColorFromString());
                    grey.setStroke(Color.GREY);
                    add(grey, col, 0);
                    col ++;
                }
            } else {
                for (int y = 0; y < 5; y++){
                    Circle black = new Circle(CIRCLE_RADIUS, Color.BLACK);
                    black.setStroke(Color.GREY);
                    add(black, y, 0);
                }
            }


            for (int i = 1; i < 8; i++){
                for (int x = 0; x < 5; x++){
                    Circle grey = new Circle(CIRCLE_RADIUS, Color.SILVER);
                    grey.setStroke(Color.BLACK);
                    if ((i == model.getCurrentRow()) && (x == model.getCurrentPon())) grey.setStroke(Color.BLANCHEDALMOND);
                    add(grey, x, i);
                }
            }

            int lig = 7;

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
        }
    }
}
