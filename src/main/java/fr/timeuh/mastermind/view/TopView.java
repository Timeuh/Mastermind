package fr.timeuh.mastermind.view;

import javafx.scene.layout.HBox;

/**
 * Top view with the pon selection and answer display
 */
public class TopView extends HBox {

    private PonSelectionView pons;
    private AnswerView answers;

    /**
     * Constructs a new top view
     */
    public TopView() {
        this.pons = new PonSelectionView();
        this.answers = new AnswerView();
        getChildren().addAll(pons, answers);
    }

    /**
     * @return the pon selection view
     */
    public PonSelectionView getPons() {
        return pons;
    }

    /**
     * @return the answer view
     */
    public AnswerView getAnswers() {
        return answers;
    }
}
