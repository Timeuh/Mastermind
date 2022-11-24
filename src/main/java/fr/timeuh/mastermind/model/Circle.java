package fr.timeuh.mastermind.model;

import javafx.scene.paint.Color;

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

    public Color getColorFromString(){
        switch (color){
            case "CRIMSON" -> {return Color.CRIMSON;}
            case "GREEN" -> {return Color.GREEN;}
            case "NAVY" -> {return Color.NAVY;}
            case "GOLD" -> {return Color.GOLD;}
            case "SADDLEBROWN" -> {return Color.SADDLEBROWN;}
            case "BLACK" -> {return Color.BLACK;}
            case "WHITE" -> {return Color.WHITE;}
            case "GREY" -> {return Color.GREY;}
            default -> {return Color.SILVER;}
        }
    }

    /**
     * @return the circle's color
     */
    public String getColor() {
        return color;
    }

    /**
     * Change the circle's color
     * @param color the new color
     */
    public void setColor(String color) {
        this.color = color;
    }
}
