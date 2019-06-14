package ru.itis.objects;

public class Main {

    public static void main(String[] args) {
	    Slip slip = new Slip();
	    Nokia3310 p1 = new Nokia3310();
	    iPhone p2 = new iPhone();

	    slip.setPhone(p2);

	    Nokia3310 myPhone = (Nokia3310)slip.getPhone();
    }
}
