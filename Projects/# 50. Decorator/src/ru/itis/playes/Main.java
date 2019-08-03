package ru.itis.playes;

public class Main {

    public static void main(String[] args) {
    	// создали базового игрока
	    SimplePlayer simplePlayer = new SimplePlayer(10);
	    // поместили его внутрь хитрого игрока
	    StealthPlayer stealthPlayer = new StealthPlayer(simplePlayer);
	    // сделали выстрел как хитрый игрок
	    stealthPlayer.shoot();
	    // сбежали как базовый игрок
	    stealthPlayer.runAway();
        System.out.println(stealthPlayer.getScore());

        CoolPlayer coolPlayer = new CoolPlayer(20);
        CowardPlayer notSoCoolPlayer = new CowardPlayer(coolPlayer);
        notSoCoolPlayer.shoot();
        notSoCoolPlayer.runAway();
		System.out.println(notSoCoolPlayer.getScore());
    }
}
