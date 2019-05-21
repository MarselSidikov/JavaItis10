package ru.itis.after;

public class Main {

    public static void main(String[] args) {
        Player marsel = new Player("Марсель", 100);
        Player oleg = new Player("Олег", 1000);
        UpgradedPlayer nadir =  new UpgradedPlayer("Надир", 100);
        UpgradedPlayer medved = new UpgradedPlayer("Медведь", Double.POSITIVE_INFINITY);

        nadir.hit(marsel);
        nadir.hit(medved);
        oleg.hit(marsel);

        System.out.println(nadir.getScore());
        System.out.println(oleg.getScore());
        System.out.println(marsel.getHealth());
        System.out.println(medved.getHealth());

        Player player = nadir;

    }
}
