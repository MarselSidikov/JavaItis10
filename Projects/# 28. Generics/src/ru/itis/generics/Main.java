package ru.itis.generics;

public class Main {

    public static void main(String[] args) {
        Nokia3310 nokia3310 = new Nokia3310();
        iPhone iPhone = new iPhone();

        Slip<Nokia3310> nokiaSlip = new Slip<>();
	    nokiaSlip.setPhone(nokia3310);
//	    nokiaSlip.setPhone(iPhone);

        Slip<iPhone> iPhoneSlip = new Slip<>();
        iPhoneSlip.setPhone(iPhone);
//        iPhoneSlip.setPhone(nokia3310);

        iPhone i = iPhoneSlip.getPhone();
        Nokia3310 n = nokiaSlip.getPhone();

        i.takeSelfie();
        n.kill();


    }
}
