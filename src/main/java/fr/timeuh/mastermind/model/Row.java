package fr.timeuh.mastermind.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Row of circles, representing a row of mastermind game pon
 */
public class Row {

    private List<Circle> circles;
    private int currentCircle;

    /**
     * Constructs a new row
     */
    public Row() {
        this.circles = new ArrayList<>();
        this.currentCircle = 0;
        fillRow();
    }

    /**
     * Construct a new row with determined circle colors
     * @param colors the colors for the circles
     */
    public Row(List<String> colors) {
        this.circles = new ArrayList<>();
        this.currentCircle = 0;
        for (String color : colors) circles.add(new Circle(color));
    }

    /**
     * Fill the row with 5 grey circles
     */
    private void fillRow() {
        for (int i = 0; i < 5; i ++) circles.add(new Circle("SILVER"));
    }

    /**
     * @return the circle list
     */
    public List<Circle> getCircles() {
        return circles;
    }
}
