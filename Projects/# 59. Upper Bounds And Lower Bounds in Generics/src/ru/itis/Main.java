package ru.itis;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void test1(List<Animal> animals) {
        animals.add(new Dog());
    }

    public static void test2(List<?> animals) {
//        animals.add(new Dog());
    }

    public static void test3(List<? super Dog> list) {
//        Animal animal = list.get(0);
//        Dog dog = list.get(0);
        list.add(new Dog());
        list.add(new Wolf());
    }

    public static void test4(List<? extends Dog> list) {
        Dog dog = list.get(0);
//        list.add(new Dog());
//        list.add(new Wolf());
//        list.add(new Animal());

    }

    public static void main(String[] args) {
        List list = new ArrayList();
        List<Object> objectsList = new ArrayList<>();
        List<Animal> animalsList = new ArrayList<>();
        List<Cat> catsList = new ArrayList<>();
        List<Tiger> tigersList = new ArrayList<>();
        List<Dog> dogsList = new ArrayList<>();
        List<Wolf> wolvesList = new ArrayList<>();

//        test1(wolvesList);
        list = objectsList;
        list = animalsList;
        list = catsList;
        list = dogsList;

//        objectsList = animalsList;
//        animalsList = dogsList;
//        dogsList = wolvesList;

        List<?> someList;
        someList = animalsList;
        someList = wolvesList;
        someList = list;

        test2(dogsList);

        test3(dogsList);
        test3(animalsList);
        // test3(wolvesList);

        test4(dogsList);
        test4(wolvesList);
//        test4(animalsList);

    }
}
