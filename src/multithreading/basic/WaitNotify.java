package multithreading.basic;

/**
 * Created by sergei.kostin on 2/2/18.
 */
public class WaitNotify {

    public synchronized void produce(){
        System.out.println("Starting produce");
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finish produce");
    }

    public synchronized void consume(){
        System.out.println("Starting consume");
        notify();
        System.out.println("Finish consume");
    }





    public static void main(String[] args) {
        WaitNotify wn = new WaitNotify();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                wn.produce();
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                wn.consume();
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
