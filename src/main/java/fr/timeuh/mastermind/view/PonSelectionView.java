package fr.timeuh.mastermind.view;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Pon selection view for the player
 */
public class PonSelectionView extends GridPane {
    private final int GRID_SPACING = 10;
    private final int GRID_HGAP = 5;
    private final int CIRCLE_RADIUS = 20;

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
                grey.setStroke(Color.BLACK);
                add(grey, x, i);
                setHgap(GRID_HGAP);
                setVgap(GRID_SPACING);
                setPadding(new Insets(GRID_SPACING));
            }
        }
    }
}
