package fr.timeuh.mastermind;

import fr.timeuh.mastermind.model.Model;
import fr.timeuh.mastermind.view.GlobalView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Appli extends Application {
    @Override
    public void start(Stage stage) {
        Model model = new Model();
        GlobalView global = new GlobalView();

        model.addObserver(global);
        model.addObserver(global.getTopView().getPons());
        model.addObserver(global.getTopView().getAnswers());

        Scene scene = new Scene(global);
        stage.setTitle("Mastermind");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}