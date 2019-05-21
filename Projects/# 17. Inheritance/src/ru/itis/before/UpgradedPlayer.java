package ru.itis.before;

public class UpgradedPlayer {
    private static final int DEFAULT_HIT_SCORE_VALUE = 1;
    private static final int INITIAL_SCORE_VALUE = 0;
    private static final int INITIAL_BULLETS_AMOUNT = 10;

    private String name;
    private int score;
    private double health;
    private int bulletsAmount;

    public UpgradedPlayer(String name, double health) {
        this.bulletsAmount = INITIAL_BULLETS_AMOUNT;
        this.score = INITIAL_SCORE_VALUE;
        this.health = health;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public int getBulletsAmount() {
        return bulletsAmount;
    }

    public void setBulletsAmount(int bulletsAmount) {
        this.bulletsAmount = bulletsAmount;
    }

    public void hit() {
        System.out.println("Бью рукой!");
        this.score += DEFAULT_HIT_SCORE_VALUE;
    }

}
