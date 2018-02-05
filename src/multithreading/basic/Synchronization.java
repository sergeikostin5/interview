package multithreading.basic;

/**
 * Created by sergei.kostin on 2/2/18.
 */
public class Synchronization {

    private static int counter = 0;

    public static void main(String[] args) {

        Synchronization s = new Synchronization();
        s.process();

    }

    public void process(){
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for(int  i = 0; i<2000; i++) {
                    add();
                }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                for(int  i = 0; i<2000; i++) {
                    add();;
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
        System.out.println(counter);
    }

    private void add(){
        synchronized (this) {
            counter++;
        }
    }

}
