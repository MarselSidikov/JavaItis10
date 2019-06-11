package ru.itis;

public class MainString {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";

        String s3 = new String("Hello");
        String s4 = new String("Hello");

        System.out.println(s1 == s2);
        System.out.println(s3 == s4);
        System.out.println(s1.equals(s4));

        String a = "Marsel";
        String b = a + ", hello";
        a = a + ", hello";
        a = a.toLowerCase();

//        for (int i = 0; i < 1000; i++) {
//            a = a + "A"; // ТАК ДЕЛАТЬ НЕЛЬЗЯ
//        }
//        System.out.print(a);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            builder.append("A");
        }
        System.out.println(builder.toString());
        System.out.println(a.charAt(1));
        System.out.println(a.charAt(a.length()));
    }
}
