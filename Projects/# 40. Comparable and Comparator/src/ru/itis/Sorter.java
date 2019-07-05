package ru.itis;

import java.util.Comparator;

/**
 * 05.07.2019
 * Sorter
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Sorter {

    public static <T> void bubbleSort(Comparable<T> array[]) {
        bubbleSort0(array, null);
    }

    public static <T> void bubbleSort(T array[], Comparator<T> comparator) {
        bubbleSort0(array, comparator);
    }

    private static <T> void bubbleSort0(T array[], Comparator<T> comparator) {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                int compareResult = 0;
                if (comparator == null) {
                    compareResult = ((Comparable<T>)array[j]).compareTo(array[j+1]);
                } else {
                    compareResult = comparator.compare(array[j], array[j+1]);
                }
                if (compareResult > 0) {
                    T temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}
