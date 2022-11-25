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
        List<Integer> goodAnswers = new ArrayList<>();
        int correctCount = 0;
        int goodColorCount = 0;
        //initialize full white
        for (int y = 0; y < 5; y++) colors.add("WHITE");

        //count corrects and well-placed pon
        for (int i = 0; i < 5; i++){
            String answerCurrent = answer.getCircles().get(i).getColor();
            String playerCurrent = playerAnswer.getCircles().get(i).getColor();
            if (answerCurrent.equals(playerCurrent)) {
                correctCount ++;
                goodAnswers.add(i);
                colors.set(i, "BLACK");
            }
        }

        //count corrects but wrong-placed pon
        for (int x = 0; x < 5; x++){
            if (colors.get(x).equals("WHITE")){
                String playerColor = playerAnswer.getCircles().get(x).getColor();
                for (int z = 0; z < 5; z++){
                    if (!goodAnswers.contains(z)){
                        String answerColor = answer.getCircles().get(z).getColor();
                        if (answerColor.equals(playerColor)){
                            goodColorCount++;
                            goodAnswers.add(z);
                            break;
                        }
                    }
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
            } else {
                colors.set(z, "WHITE");
            }
        }

        return new Row(colors);
    }
}
