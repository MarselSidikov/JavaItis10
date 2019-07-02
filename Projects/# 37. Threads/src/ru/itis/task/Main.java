package ru.itis.task;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numbersSum = 0;

        int numbersCount = scanner.nextInt();
        int threadsCount = scanner.nextInt();

        int numbers[] = new int[numbersCount];

        for (int i= 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1000);
        }

        long before = System.currentTimeMillis();
        for (int i = 0; i < numbers.length; i++) {
            int digitsSum = 0;
            int copy = numbers[i];
            while (copy != 0) {
                digitsSum = copy % 10;
                copy = copy / 10;
            }
            numbersSum += digitsSum;
        }
        long after = System.currentTimeMillis();
        System.out.println("Затрачено:" + (after - before));

        System.out.println(numbersSum);

        SumThread threads[] = new SumThread[threadsCount];

        int numbersCountForOneThread = numbersCount / threadsCount;
        int start = 0;
        int finish = numbersCountForOneThread;

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new SumThread(numbers, start, finish);
            start = finish;
            finish += numbersCountForOneThread;
        }
        threads[threadsCount - 1].setFinish(numbersCount);

        before = System.currentTimeMillis();
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }

        int sumByThreads = 0;

        for (int i = 0; i < threads.length; i++) {
            sumByThreads += threads[i].getResult();
        }
        after = System.currentTimeMillis();
        System.out.println("Затрачено: " + (after - before));
        System.out.println(sumByThreads);
    }
}
