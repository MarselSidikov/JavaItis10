package ru.itis;

public class Main {

    public static void main(String[] args) {
        System.out.println(SomeClass.b);
        SomeClass.b = 100;
        SomeClass object1 = new SomeClass();
        SomeClass object2 = new SomeClass(10);
        SomeClass object3 = new SomeClass();
        object3.a = 5;
//        object3.b = 5;

        System.out.println(object1.a);
        System.out.println(object2.a);
        System.out.println(object3.a);

//        System.out.println(object1.b);
//        System.out.println(object2.b);
//        System.out.println(object3.b);
        System.out.println(SomeClass.b);

        SomeClass.generateAndPrint(1, 10);
    }
}
