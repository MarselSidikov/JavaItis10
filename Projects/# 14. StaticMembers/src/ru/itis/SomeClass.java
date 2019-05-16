package ru.itis;

public class SomeClass {
    static final int CONST = 5;

    int a;
    static int b = 300;

    // статический инициализатор
    static {
        b = 500;
    }

    SomeClass() {
        a = 1;
//        this.b = 1;
    }

    SomeClass(int a) {
        this.a = a;
//        this.b = b;
    }

    static void generateAndPrint(int from, int to) {
        System.out.println(b);
        for (int i = from; i <= to; i++) {
            System.out.println(i + " ");
        }
    }
}
