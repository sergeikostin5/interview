package multithreading.basic;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock has same functionality with synchronized plus some additional features like fairness. If fairness
 * parameter is set to true, the longest waiting thread will get the lock. Fairness false --> there is no access order
 */
public class ProducerConsumerWithLocks {

    List<Integer> list = new LinkedList<>();
    private static final int LIMIT = 5;
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void produce() throws InterruptedException {
        while(true){
            lock.lock();
            if(list.size() == LIMIT){
                System.out.println("Producer waiting" + list.size());
                condition.await();
            }else{
                System.out.println("Adding numbber");
                list.add(2);
                condition.signal();
            }
            Thread.sleep(1000);
        }
    }

    public void consume() throws InterruptedException {
        while(true){
            lock.lock();
            if(list.isEmpty()){
                System.out.println("Consumer waiting" + list.size());
                condition.await();
            }else{
                lock.lock();
                System.out.println("Removing numbber");
                list.remove(list.size()-1);
                condition.signal();
            }
            Thread.sleep(1000);
        }
    }

    public static void main(String[] args) {
        ProducerConsumerWithLocks pc = new ProducerConsumerWithLocks();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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



    }

}
