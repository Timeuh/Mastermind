package fr.timeuh.mastermind.view;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

/**
 * Global view of the application
 */
public class GlobalView extends BorderPane {

    private ColorSelectionView colorSelection;
    private MenuView menu;
    private TopView top;

    /**
     * Constructs a new global view
     */
    public GlobalView() {
        this.colorSelection = new ColorSelectionView();
        this.menu = new MenuView();
        this.top = new TopView();

        setTop(top);
        setBottom(colorSelection);
        setCenter(menu);
        setBackground(new Background(new BackgroundFill(Color.GREY, null, null)));
    }

    /**
     * @return the color selection view
     */
    public ColorSelectionView getColorSelection() {
        return colorSelection;
    }

    /**
     * @return the menu view
     */
    public MenuView getMenu() {
        return menu;
    }

    /**
     * @return the top view
     */
    public TopView getTopView() {
        return top;
    }
}
