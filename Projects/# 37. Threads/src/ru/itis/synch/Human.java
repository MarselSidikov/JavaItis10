package ru.itis.synch;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Human extends Thread {
    private final BonusCard bonusCard;

//    private static final Object MUTEX = new Object();

    private static final Lock lock = new ReentrantLock();

    public Human(String name, BonusCard bonusCard) {
        super(name);
        this.bonusCard = bonusCard;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
//            synchronized (MUTEX) {
            lock.lock();
            if (bonusCard.getBonuses() > 0) {
                System.out.println(bonusCard.getBonuses() + " " + Thread.currentThread().getName() + " собрался покупать");
                bonusCard.use(1);
                System.out.println(bonusCard.getBonuses() + " " + Thread.currentThread().getName() + " купил");
            } else {
                System.out.println(bonusCard.getBonuses() + " " + Thread.currentThread().getName() + " пошел домой");
                break;
            }
            lock.unlock();
//            }
        }
    }


}
