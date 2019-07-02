package ru.itis.cooperation;

public class Producer extends Thread {
    private final Product product;

    public Producer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (product) {
                while (!product.isConsumed()) {
                    System.out.println("Producer ждет");
                    try {
                        product.wait();
                    } catch (InterruptedException e) {
                        throw new IllegalStateException(e);
                    }
                }
                System.out.println("Producer подготовил");
                product.produce();
                product.notify();
            }
        }
    }
}
