package ru.itis.playes;


// Decorator
// позволяет добавить/изменить существующую функциональность
public abstract class FlexiblePlayer extends Player {

    // ссылка на игрока
    protected Player player;

    public FlexiblePlayer(Player player) {
        this.player = player;
    }

    // при выстреле используется реализация игрока, который
    // был подан на вход
    @Override
    public void shoot() {
        player.shoot();
    }

    @Override
    public void runAway() {
        player.runAway();
    }

    @Override
    public int getScore() {
        return player.getScore();
    }
}
