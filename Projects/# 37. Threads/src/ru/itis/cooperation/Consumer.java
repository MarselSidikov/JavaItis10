package ru.itis.cooperation;

public class Consumer extends Thread {
    private final Product product;

    public Consumer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (product) {
                while (!product.isProduced()) {
                    System.out.println("Consumer ждет");
                    try {
                        product.wait();
                    } catch (InterruptedException e) {
                        throw new IllegalStateException(e);
                    }
                }
                System.out.println("Consumer потребил");
                product.consume();
                product.notify();
            }
        }
    }

}
