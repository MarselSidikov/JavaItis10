package ru.itis.sequences;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int array[] = {2, 3, 5, 1, 8, 9};
        Sequence sequence = new SequenceArrayImpl(array);
//        System.out.println(Arrays.toString(sequence.getAll()));
//        System.out.println(sequence.get());
//        System.out.println(sequence.get());
//        System.out.println(sequence.get());

        Sequence evensSequence = new EvensSequence(sequence);
        System.out.println(Arrays.toString(evensSequence.getAll()));
//        System.out.println(evensSequence.get());
//        System.out.println(evensSequence.get());
//        System.out.println(evensSequence.get());
    }
}
