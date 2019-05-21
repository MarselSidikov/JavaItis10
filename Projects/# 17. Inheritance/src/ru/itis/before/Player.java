package ru.itis.before;

public class Player {
    private static final int DEFAULT_HIT_SCORE_VALUE = 1;
    private static final int INITIAL_SCORE_VALUE = 0;

    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = INITIAL_SCORE_VALUE;

    }

    public void hit() {
        System.out.println("Бью рукой!");
        this.score += DEFAULT_HIT_SCORE_VALUE;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
