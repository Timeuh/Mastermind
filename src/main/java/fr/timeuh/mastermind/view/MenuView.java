package fr.timeuh.mastermind.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * Game menu view
 */
public class MenuView extends HBox {
    private final int BUTTON_WIDTH = 100;
    private final int BOX_SPACING = 10;

    /**
     * Constructs a new menu view
     */
    public MenuView() {
        init();
    }

    /**
     * Initialize the view with the components
     */
    private void init(){
        Button start = new Button("Start");
        start.setTextFill(Color.CRIMSON);

        Button reset = new Button("Reset");
        reset.setTextFill(Color.GREEN);

        Button beginner = new Button("Beginner");
        beginner.setTextFill(Color.NAVY);

        Button pro = new Button("Pro");
        pro.setTextFill(Color.GOLD);

        Button validate = new Button("Validate");
        validate.setTextFill(Color.SADDLEBROWN);

        Button dayNight = new Button("Day/Nigth mode");
        dayNight.setTextFill(Color.BLACK);

        getChildren().addAll(start, reset, beginner, pro, validate, dayNight);

        for (Node node : getChildren()){
            if (node instanceof Button button){
                button.setMinWidth(BUTTON_WIDTH);
                button.setStyle("-fx-font-weight: bold");
                button.setBackground(new Background(new BackgroundFill(Color.SILVER, null, null)));
                button.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            }
        }

        setSpacing(BOX_SPACING);
        setPadding(new Insets(BOX_SPACING));
        setAlignment(Pos.CENTER);
    }
}
