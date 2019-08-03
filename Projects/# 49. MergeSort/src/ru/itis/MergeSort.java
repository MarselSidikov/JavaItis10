package ru.itis;

public class MergeSort {

    private static int helpArray[];

    static {
        helpArray = new int[200];
    }

    // передаем массив и говорим
    // от какой до какой границы мы сортируем
    public static void sort(int array[], int lower, int higher) {
        // выводим сообщение о сортировке
        LogUtils.log(array, "sort", lower, higher);
        // если остался один элемент - останавливаем текущий вызов
        if (higher <= lower) {
            return;
        }
        // вычисляем середину текущих границ
        int middle = lower + (higher - lower) / 2;
        LogUtils.indentUp();
        // сортируем левую половину
        sort(array, lower, middle);
        // сортируем правую половину
        sort(array, middle + 1, higher);
        // сливаем
        merge(array, lower, middle, higher);

        LogUtils.indentDown();
    }

    private static void merge(int array[], int lower, int middle, int higher) {
        // копируем кусок исходного массива в вспомогательный
        for (int currentIndex = lower; currentIndex <= higher; currentIndex++) {
            helpArray[currentIndex] = array[currentIndex];
        }
        // заводим две переменные и начинаем слияние
        int i = lower, j = middle + 1;
        for (int currentIndex = lower; currentIndex <= higher; currentIndex++) {
            if (i > middle) {
                array[currentIndex] = helpArray[j];
                j++;
            } else if (j > higher) {
                array[currentIndex] = helpArray[i];
                i++;
            } else if (helpArray[j] < helpArray[i]) {
                array[currentIndex] = helpArray[j];
                j++;
            } else {
                array[currentIndex] = helpArray[i];
                i++;
            }
        }
        LogUtils.log(array, "merge", lower, higher);
    }
}