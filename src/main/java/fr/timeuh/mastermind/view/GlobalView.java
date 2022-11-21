package fr.timeuh.mastermind.view;

import javafx.scene.layout.BorderPane;

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
