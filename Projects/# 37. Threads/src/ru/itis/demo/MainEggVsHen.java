package ru.itis.demo;

public class MainEggVsHen {
    public static void main(String[] args) {
        EggThread eggThread = new EggThread();
        HenThread henThread = new HenThread();

        eggThread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("Человек");
        }

        henThread.start();
    }
}
