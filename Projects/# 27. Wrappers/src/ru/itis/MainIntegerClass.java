package ru.itis;

public class MainIntegerClass {
    public static void main(String[] args) {
        // упаковка -> boxing, упаковали примитивный
        // тип в оберточный (ссылочный)
        Integer i1 = new Integer(5);

        // автоупаковка -> autoboxing
        Integer i2 = 5;

        // unboxing -> распаковка - забрали примитивный тип
        // из оберточного
        int i3 = i1.intValue();

        // autounboxing
        int i4 = i1;
    }
}
