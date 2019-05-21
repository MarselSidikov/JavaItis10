package ru.itis.after;

public class UpgradedPlayer extends Player {
    private static final int INITIAL_BULLETS_AMOUNT = 10;

    private int bulletsAmount;
    private Gun gun;

    public UpgradedPlayer(String name, double health) {
        super(name, health);
        this.bulletsAmount = INITIAL_BULLETS_AMOUNT;
        this.gun = new Gun();
    }

    public void hit(Player player) {
        gun.bang(player);
        this.bulletsAmount--;
        this.setScore(this.getScore() + gun.getBonus());
    }

    public int getBulletsAmount() {
        return bulletsAmount;
    }

    public void setBulletsAmount(int bulletsAmount) {
        this.bulletsAmount = bulletsAmount;
    }
}
