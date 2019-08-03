package ru.itis.playes;

// реализация хитрого игрока
public class StealthPlayer extends FlexiblePlayer {

    public StealthPlayer(Player player) {
        super(player);
    }

    // изменили поведение при выстреле - у этого типа игрока очков
    // начисляется больше
    @Override
    public void shoot() {
        super.player.score = super.player.score + 10;
    }
}
