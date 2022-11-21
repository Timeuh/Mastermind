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
    }
}
