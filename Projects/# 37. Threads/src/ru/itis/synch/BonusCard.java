package ru.itis.synch;

public class BonusCard {
    private int bonuses;

    public BonusCard(int bonuses) {
        this.bonuses = bonuses;
    }

    public void use(int bonuses) {
        if (this.bonuses >= bonuses) {
            this.bonuses = this.bonuses - bonuses;
        } else {
            System.out.println("Денег нет");
            System.exit(0);
        }
    }

    public int getBonuses() {
        return bonuses;
    }
}
