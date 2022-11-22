package fr.timeuh.mastermind.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Color selection for answer pon
 */
public class ColorSelectionView extends HBox {
    private final int CIRCLE_RADIUS = 20;
    private final int BOX_SPACING = 10;

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
        Circle red = new Circle(CIRCLE_RADIUS, Color.CRIMSON);
        Circle green = new Circle(CIRCLE_RADIUS, Color.GREEN);
        Circle blue = new Circle(CIRCLE_RADIUS, Color.NAVY);
        Circle yellow = new Circle(CIRCLE_RADIUS, Color.GOLD);
        Circle brown = new Circle(CIRCLE_RADIUS, Color.SADDLEBROWN);
        getChildren().addAll(red, green, blue, yellow, brown);

        for (Node node : getChildren()){
            if (node instanceof Circle circle) circle.setStroke(Color.BLACK);
        }

        setSpacing(BOX_SPACING);
        setPadding(new Insets(BOX_SPACING));
        setAlignment(Pos.CENTER);
    }
}
