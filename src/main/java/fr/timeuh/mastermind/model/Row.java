package fr.timeuh.mastermind.model;

import java.util.ArrayList;
import java.util.List;

public class Row {

    private List<Circle> circles;
    private int currentCircle;

    public Row() {
        this.circles = new ArrayList<>();
        this.currentCircle = 0;
    }
}
