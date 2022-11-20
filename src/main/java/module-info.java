module fr.timeuh.mastermind {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.timeuh.mastermind to javafx.fxml;
    exports fr.timeuh.mastermind;
}