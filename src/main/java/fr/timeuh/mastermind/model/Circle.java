package fr.timeuh.mastermind.model;

/**
 * Circle representing a pon of mastermind game
 */
public class Circle {

    private String color;

    /**
     * Constructs a new circle
     * @param color the color of the circle
     */
    public Circle(String color) {
        this.color = color;
    }

    /**
     * @return the circle's color
     */
    public String getColor() {
        return color;
    }
}
