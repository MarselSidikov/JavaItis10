package ru.itis;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Double x2 = 2.0;
        Double x3 = 3.0;
        Double x4 = 4.0;
        Double x5 = 5.0;
        Double x6 = 6.0;
        Double x7 = 7.0;

        System.out.println(Integer.toBinaryString(x2.hashCode()));
        System.out.println(Integer.toBinaryString(x3.hashCode()));
        System.out.println(Integer.toBinaryString(x4.hashCode()));
        System.out.println(Integer.toBinaryString(x5.hashCode()));
        System.out.println(Integer.toBinaryString(x6.hashCode()));
        System.out.println(Integer.toBinaryString(x7.hashCode()));
        System.out.println("After RIGHT SHIFT >>> ");
        System.out.println("0000000000000000" + Integer.toBinaryString(x2.hashCode() >>> 16));
        System.out.println("0000000000000000" + Integer.toBinaryString(x3.hashCode() >>> 16));
        System.out.println("0000000000000000" + Integer.toBinaryString(x4.hashCode() >>> 16));
        System.out.println("0000000000000000" + Integer.toBinaryString(x5.hashCode() >>> 16));
        System.out.println("0000000000000000" + Integer.toBinaryString(x6.hashCode() >>> 16));
        System.out.println("0000000000000000" + Integer.toBinaryString(x7.hashCode() >>> 16));
        System.out.println("After XOR ^");
        System.out.println(Integer.toBinaryString(x2.hashCode() ^ (x2.hashCode() >>> 16)));
        System.out.println(Integer.toBinaryString(x3.hashCode() ^ (x3.hashCode() >>> 16)));
        System.out.println(Integer.toBinaryString(x4.hashCode() ^ (x4.hashCode() >>> 16)));
        System.out.println(Integer.toBinaryString(x5.hashCode() ^ (x5.hashCode() >>> 16)));
        System.out.println(Integer.toBinaryString(x6.hashCode() ^ (x6.hashCode() >>> 16)));
        System.out.println(Integer.toBinaryString(x7.hashCode() ^ (x7.hashCode() >>> 16)));

    }
}
