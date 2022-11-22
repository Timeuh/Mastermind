package fr.timeuh.mastermind.view;

import fr.timeuh.mastermind.model.Model;
import fr.timeuh.mastermind.model.Subject;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

/**
 * Global view of the application
 */
public class GlobalView extends BorderPane implements Observer{

    private ColorSelectionView colorSelection;
    private MenuView menu;
    private TopView top;
    private Color current;

    /**
     * Constructs a new global view
     */
    public GlobalView() {
        this.colorSelection = new ColorSelectionView();
        this.menu = new MenuView();
        this.top = new TopView();
        this.current = Color.GREY;

        setTop(top);
        setBottom(colorSelection);
        setCenter(menu);
        changeLighting();
    }

    private void changeLighting(){
        if (current == Color.GREY){
            setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
            current = Color.WHITE;
        }
        else if (current == Color.WHITE){
            setBackground(new Background(new BackgroundFill(Color.GREY, null, null)));
            current = Color.GREY;
        }
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

    /**
     * Update the view with the model data
     * @param subject the subject they are watching
     */
    @Override
    public void update(Subject subject) {
        if (subject instanceof Model model){
            if (model.getBackground() != current){
                changeLighting();
                current = model.getBackground();
            }
        }
    }
}
