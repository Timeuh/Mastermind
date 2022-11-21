package fr.timeuh.mastermind.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Difficulty beginner
 */
public class DifficultyBeginner implements Difficulty{

    /**
     * Construct a new beginner difficulty
     */
    public DifficultyBeginner() {
    }

    /**
     * Correct the player answer, placing correction circles in the order of the player's answer
     * @param answer the model answer
     * @param playerAnswer the player's current answer
     * @return a row with correction circles
     */
    @Override
    public Row correctPlayerAnswer(Row answer, Row playerAnswer) {
        List<String> colors = new ArrayList<>();

        for (int i = 0; i < 5; i++){
            Circle expected = answer.getCircles().get(i);
            Circle current = playerAnswer.getCircles().get(i);

            if (current.getColor().equals(expected.getColor())) colors.add("Black");
        }

        return new Row(colors);
    }
}
