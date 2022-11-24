package fr.timeuh.mastermind;

import fr.timeuh.mastermind.controller.ControlColorSelection;
import fr.timeuh.mastermind.controller.ControlMenu;
import fr.timeuh.mastermind.controller.ControlPonSelection;
import fr.timeuh.mastermind.model.Model;
import fr.timeuh.mastermind.view.GlobalView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Appli extends Application {
    @Override
    public void start(Stage stage) {
        Model model = new Model();
        GlobalView global = new GlobalView();

        model.addObserver(global);
        model.addObserver(global.getPons());

        global.getMenu().addEventHandler(ActionEvent.ACTION, new ControlMenu(model));
        global.getPons().addEventHandler(MouseEvent.MOUSE_CLICKED, new ControlPonSelection(model));
        global.getColorSelection().addEventHandler(MouseEvent.MOUSE_CLICKED, new ControlColorSelection(model));

        Scene scene = new Scene(global);
        stage.setTitle("Mastermind");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}