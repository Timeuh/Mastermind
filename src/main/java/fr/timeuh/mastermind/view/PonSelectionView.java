package fr.timeuh.mastermind.view;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Pon selection view for the player
 */
public class PonSelectionView extends GridPane {

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
        for (int i = 1; i < 8; i++){
            for (int x = 0; x < 5; x++){
                Circle grey = new Circle(20, Color.GREY);
                grey.setStroke(Color.BLACK);
                add(grey, x, i);
            }
        }
    }
}
