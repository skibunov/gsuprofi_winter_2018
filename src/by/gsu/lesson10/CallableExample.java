package by.gsu.lesson10;

import java.util.Random;
import java.util.concurrent.*;

public class CallableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service
                = Executors.newSingleThreadExecutor();

        Future<Integer> future = service.submit(new SomeCallable());

        service.shutdown();

        System.out.println("from main!");
        System.out.println(future.get());

    }

    public static class SomeCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            sleepRandom(10000);
            System.out.println("from another!");
            return 42;
        }
    }


    public static void sleepRandom(int to) {
        Random random = new Random();
        int time = random.nextInt(to);


        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
