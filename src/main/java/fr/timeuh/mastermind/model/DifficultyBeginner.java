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
     * Correct the player's answer, placing correction circles in the order of the player's answer
     * @param answer the model answer
     * @param playerAnswer the player's current answer
     * @return a row with correction circles
     */
    @Override
    public Row correctPlayerAnswer(Row answer, Row playerAnswer) {
        List<String> colors = new ArrayList<>();
        List<Integer> goodAnswers = new ArrayList<>();
        //initialize full white
        for (int y = 0; y < 5; y++) colors.add("WHITE");

        //change color to black if player's pon is good color and well-placed
        for (int i = 0; i < 5; i++){
            Circle expected = answer.getCircles().get(i);
            Circle current = playerAnswer.getCircles().get(i);
            if (current.getColor().equals(expected.getColor())){
                colors.set(i, "BLACK");
                goodAnswers.add(i);
            }
        }

        //change color to grey if pon is good color but wrong-placed
        for (int x = 0; x < 5; x++){
            if (colors.get(x).equals("WHITE")){
                String playerColor = playerAnswer.getCircles().get(x).getColor();
                for (int z = 0; z < 5; z++){
                    if (!goodAnswers.contains(z)){
                        String answerColor = answer.getCircles().get(z).getColor();
                        if (answerColor.equals(playerColor)){
                            colors.set(x, "GREY");
                            goodAnswers.add(z);
                        }
                    }
                }
            }
        }

        return new Row(colors);
    }
}
