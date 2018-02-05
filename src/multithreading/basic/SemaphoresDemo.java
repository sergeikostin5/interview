package multithreading.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by sergei.kostin on 2/3/18.
 */
public class SemaphoresDemo {

    private Semaphore semaphore = new Semaphore(3,true);

    public void downloadData(){
        try {
            semaphore.acquire();
            System.out.println("Started Download");
            Thread.sleep(2000);
            System.out.println("Finished Download");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        SemaphoresDemo demo = new SemaphoresDemo();
        ExecutorService service = Executors.newCachedThreadPool();
        for(int i = 0; i<12; i++){
            service.execute(new Runnable() {
                @Override
                public void run() {
                    demo.downloadData();
                }
            });
        }
    }



}
