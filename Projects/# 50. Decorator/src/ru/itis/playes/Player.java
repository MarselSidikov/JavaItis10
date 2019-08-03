package ru.itis.playes;

// Component
// Базовый игрок
public abstract class Player {
    // набор очков
    protected int score;

    // метод для получения очков
    public int getScore() {
        return score;
    }

    // поведение игрока - выстрел и побег
    public abstract void shoot();
    public abstract void runAway();
}
