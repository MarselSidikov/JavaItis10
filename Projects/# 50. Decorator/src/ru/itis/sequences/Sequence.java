package ru.itis.sequences;

// Это как InputStream
public abstract class Sequence {
    // это как read
    // get должен вернуть -1, если последовательность кончилась
    public abstract int get();

    // получить все из последовательности
    public int[] getAll() {
        // массив-результат, который мы возвращаем
        int result[] = new int[10];
        // прочитали первое число какой-то последовательности
        int value = get();
        int i = 0;
        // пока есть что читать - читаем и заполняем массив
        while (value != -1) {
            result[i] = value;
            value = get();
            i++;
        }
        return result;
    }

    public int[] getAllReversed() {
        int result[] = getAll();
        for (int i = 0; i < result.length / 2; i++) {
            int temp = result[i];
            result[i] = result[result.length - 1 - i];
            result[result.length - 1 - i] = temp;
        }
        return result;
    }
}
