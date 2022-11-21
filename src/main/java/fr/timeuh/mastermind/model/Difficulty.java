package fr.timeuh.mastermind.model;

/**
 * Difficulty of the game
 */
public interface Difficulty {

    /**
     * Display the correction of player's answer
     */
    public Row correctPlayerAnswer(Row answer, Row playerAnswer);
}
