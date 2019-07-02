package ru.itis.cooperation;

public class Main {
    public static void main(String[] args) {
        Product product = new Product();
        Consumer consumer = new Consumer(product);
        Producer producer = new Producer(product);

        consumer.start();
        producer.start();
    }
}
