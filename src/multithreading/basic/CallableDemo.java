package multithreading.basic;

import java.util.concurrent.*;

/**
 * Created by sergei.kostin on 2/3/18.
 */
public class CallableDemo {

    private static class Worker implements Callable<String>{

        int n;

        Worker(int i){
            n=i;
        }

        @Override
        public String call() throws Exception {
            System.out.println("Started");
            Thread.sleep(5000);
            return "id " + n;
        }
    }

    public static void main(String[] args) {

        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> future = service.submit(new Worker(3));
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }

}
