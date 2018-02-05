package multithreading.basic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock has same functionality with synchronized plus some additional features like fairness. If fairness
 * parameter is set to true, the longest waiting thread will get the lock. Fairness false --> there is no access order
 */
public class ReentrantLocks {

    private static Lock lock = new ReentrantLock();
    private static int counter = 0;

    public static void increment(){
        lock.lock();
        try{
            for(int i = 0; i < 1000; i++){
                counter++;
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
               increment();
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                increment();
            }
        };
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter);
    }

}
