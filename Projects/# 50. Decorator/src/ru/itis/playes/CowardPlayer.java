package ru.itis.playes;

public class CowardPlayer extends FlexiblePlayer {
    public CowardPlayer(Player player) {
        super(player);
    }

    @Override
    public void runAway() {
        super.player.score -= 5;
    }
}
