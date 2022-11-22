package fr.timeuh.mastermind.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Difficulty pro
 */
public class DifficultyPro implements Difficulty{

    /**
     * Construct a new pro difficulty
     */
    public DifficultyPro() {
    }

    /**
     * Correct the player's answer, placing circle in color order, not answer order
     * @param answer the model answer
     * @param playerAnswer the player's current answer
     * @return a row with correction circles
     */
    @Override
    public Row correctPlayerAnswer(Row answer, Row playerAnswer) {
        List<String> colors = new ArrayList<>();
        int correctCount = 0;
        int goodColorCount = 0;
        //initialize full white
        for (int y = 0; y < 5; y++) colors.add("WHITE");

        //count corrects and well-placed pon
        for (int i = 0; i < 5; i++){
            String answerCurrent = answer.getCircles().get(i).getColor();
            String playerCurrent = playerAnswer.getCircles().get(i).getColor();
            if (answerCurrent.equals(playerCurrent)) correctCount ++;
        }

        //count corrects but wrong-placed pon
        for (int x = 0; x < 5; x++){
            if (colors.get(x).equals("WHITE")){
                String searched = answer.getCircles().get(x).getColor();
                for (Circle circle : playerAnswer.getCircles()){
                    if (circle.getColor().equals(searched)) goodColorCount ++;
                }
            }
        }

        //replace colors in order : Black-Grey-White without considering answer order
        for (int z = 0; z < 5; z++){
            if (correctCount > 0){
                colors.set(z, "BLACK");
                correctCount --;
            } else if (goodColorCount > 0){
                colors.set(z, "GREY");
                goodColorCount --;
            }
        }

        return new Row(colors);
    }
}
