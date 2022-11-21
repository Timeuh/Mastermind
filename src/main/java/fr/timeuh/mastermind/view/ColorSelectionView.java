package fr.timeuh.mastermind.view;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Color selection for answer pon
 */
public class ColorSelectionView extends HBox {

    /**
     * Constructs a new color selection view
     */
    public ColorSelectionView() {
        init();
    }

    /**
     * Initialize the view
     */
    private void init(){
        setAlignment(Pos.CENTER);
        Circle red = new Circle(20, Color.RED);
        Circle green = new Circle(20, Color.GREEN);
        Circle blue = new Circle(20, Color.BLUE);
        Circle yellow = new Circle(20, Color.YELLOW);
        Circle brown = new Circle(20, Color.BROWN);
        getChildren().addAll(red, green, blue, yellow, brown);
        for (Node node : getChildren()){
            if (node instanceof Circle circle) circle.setStroke(Color.BLACK);
        }
    }
}
