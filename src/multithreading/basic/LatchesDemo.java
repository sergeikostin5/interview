package multithreading.basic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sergei.kostin on 2/3/18.
 */
public class LatchesDemo {

    public static class Worker implements Runnable{
        int id;
        CountDownLatch latch ;

        Worker(int id, CountDownLatch latch){
            this.id = id;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println("Thread " + id + " is working");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
            System.out.println("Thread " + id + " is done");

        }
    }

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(5);
        ExecutorService service = Executors.newFixedThreadPool(2);
        for(int i =0; i < 10; i++){
            service.execute(new Worker(i, latch));
        }
        try {
            latch.await();
            System.out.println("Done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
