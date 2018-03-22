package multithreading.basic;

/**
 * Created by sergei.kostin on 2/2/18.
 */
public class WaitNotify {

    private Object lock = new Object();

    public void doWait() {
        synchronized (lock){
            System.out.println("First thread got the lock");
            System.out.println("First wait()");
            try {
                lock.wait();
                System.out.println("First thread is back");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void doNotify(){
        synchronized (lock){
            System.out.println("Second Thread got the lock");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           lock.notify();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Second Thread released the lock");
        }
    }





    public static void main(String[] args) {
        WaitNotify wn = new WaitNotify();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                wn.doWait();
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                wn.doNotify();
            }
        };

        t1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
