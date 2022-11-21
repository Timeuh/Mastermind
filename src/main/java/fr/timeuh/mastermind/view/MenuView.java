package fr.timeuh.mastermind.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 * Game menu view
 */
public class MenuView extends HBox {

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
        setAlignment(Pos.CENTER);
        Button start = new Button("Start");
        Button reset = new Button("Reset");
        Button beginner = new Button("Beginner");
        Button pro = new Button("Pro");
        Button validate = new Button("Validate");
        getChildren().addAll(start, reset, beginner, pro, validate);
    }
}
