package ru.itis.playes;

public class CoolPlayer extends Player {

    public CoolPlayer(int score) {
        this.score = score;
    }

    @Override
    public void shoot() {
        this.score += 15;
    }

    @Override
    public void runAway() {
        this.score += 1;
    }
}
