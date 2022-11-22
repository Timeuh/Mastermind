package fr.timeuh.mastermind.view;

import javafx.scene.layout.HBox;

/**
 * Top view with the pon selection and answer display
 */
public class TopView extends HBox {

    private PonSelectionView pons;

    /**
     * Constructs a new top view
     */
    public TopView() {
        this.pons = new PonSelectionView();
        getChildren().addAll(pons);
    }

    /**
     * @return the pon selection view
     */
    public PonSelectionView getPons() {
        return pons;
    }
}
