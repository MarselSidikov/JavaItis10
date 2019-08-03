package ru.itis.playes;

// ConcreteComponent
// Базовая реализация игрока
public class SimplePlayer extends Player {

    public SimplePlayer(int score) {
        this.score = score;
    }

    @Override
    public void shoot() {
        this.score++;
    }

    @Override
    public void runAway() {
        this.score--;
    }
}
