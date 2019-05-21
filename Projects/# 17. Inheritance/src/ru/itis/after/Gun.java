package ru.itis.after;

public class Gun {
    private static int DAMAGE = 10;
    private static int BONUS = 5;

    public void bang(Player player) {
        System.out.println("Bang!");
        player.setHealth(player.getHealth() - DAMAGE);
    }

    public int getBonus() {
        return BONUS;
    }
}
