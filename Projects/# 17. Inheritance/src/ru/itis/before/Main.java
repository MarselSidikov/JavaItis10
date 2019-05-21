package ru.itis.before;

public class Main {

    public static void main(String[] args) {
        Player player = new Player("Марсель");
        player.hit();
        player.hit();
        System.out.println(player.getName() + " имеет " + player.getScore() + " очков");

        UpgradedPlayer upgradedPlayer =  new UpgradedPlayer("Надир", 100);
        upgradedPlayer.hit();
        upgradedPlayer.hit();
        upgradedPlayer.hit();
        System.out.println(upgradedPlayer.getName() + " имеет " + upgradedPlayer.getScore() + " очков");


    }
}
