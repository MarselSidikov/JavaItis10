package ru.itis.demo;

public class Main {

    public static void main(String[] args) throws Exception {
	    Thread thread = Thread.currentThread();

        System.out.println(thread.getName());

        Thread.sleep(5000);

        System.out.println("After sleep");
    }
}
