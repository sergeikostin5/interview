package multithreading.basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sergei.kostin on 2/3/18.
 */
public class ProducerConsumer {

    List<Integer> list = new LinkedList<>();
    private static final int LIMIT = 5;

    public synchronized void produce() throws InterruptedException {
        while(true){

            if(list.size() == LIMIT){
                System.out.println("Producer " + list.size());
                wait();
            }else{
                System.out.println("Adding numbber");
                list.add(2);
                notify();
            }
            Thread.sleep(1000);
        }
    }

    public synchronized void consume() throws InterruptedException {
        while(true){

            if(list.isEmpty()){
                System.out.println("Consumer " + list.size());
                wait();
            }else{
                System.out.println("Removing numbber");
                list.remove(list.size()-1);
                notify();
            }
            Thread.sleep(1000);
        }
    }

    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();
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
