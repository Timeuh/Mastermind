package fr.timeuh.mastermind;

import fr.timeuh.mastermind.controller.ControlMenu;
import fr.timeuh.mastermind.model.Model;
import fr.timeuh.mastermind.view.GlobalView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Appli extends Application {
    @Override
    public void start(Stage stage) {
        Model model = new Model();
        GlobalView global = new GlobalView();

        model.addObserver(global);
        model.addObserver(global.getTopView().getPons());

        global.getMenu().addEventHandler(ActionEvent.ACTION, new ControlMenu(model));

        Scene scene = new Scene(global);
        stage.setTitle("Mastermind");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}