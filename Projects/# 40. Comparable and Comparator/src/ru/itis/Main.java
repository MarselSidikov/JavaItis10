package ru.itis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Human marsel = new Human(25, "Марсель", 1.85);
        Human ilya = new Human(26, "Илья", 1.80);
        Human oleg = new Human(23, "Олег", 1.81);
        Human nail = new Human(37, "Наиль", 1.79);
        Human aydar = new Human(29, "Айдар", 1.90);
        Human damir = new Human(19, "Дамир", 1.80);

        Human humans[] = {marsel, ilya, oleg, nail, aydar, damir};

        Sorter sorter = new Sorter();

//        Scanner scanner = new Scanner(System.in);
////        Scanner scanner1 = new Scanner(System.in);
////        Scanner scanner2 = new Scanner(System.in);
////
////        Scanner scanners[] = {scanner, scanner1, scanner2};
////        sorter.bubbleSort(scanners);

        sorter.bubbleSort(humans);

        System.out.println(Arrays.toString(humans));

        sorter.bubbleSort(humans,
                (o1, o2) -> Double.compare(o1.getHeight(), o2.getHeight()));

        System.out.println(Arrays.toString(humans));
    }
}
