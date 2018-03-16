package by.gsu.lesson9;

import java.util.concurrent.atomic.AtomicInteger;

public class SyncExample {
    public volatile static int AN_INT = 0;
    public static AtomicInteger ai = new AtomicInteger();

    public static Object monitor = new Object();

    public static void main(String[] args) throws InterruptedException {

//        System.out.println(AN_INT);
//        System.out.println(ai.get());

        Thread t1 = new Thread(new T1());
        Thread t2 = new Thread(new T2());

        long start = System.currentTimeMillis();

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        long end = System.currentTimeMillis();
        System.out.println(ai.get());
        System.out.println(end - start);
    }

    public static class T1 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 1_000_000_00; i++) {
                ai.incrementAndGet();
//                synchronized(monitor) {
//                    AN_INT++;
//                }
            }
        }
    }

    public static class T2 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 1_000_000_00; i++) {
                ai.decrementAndGet();
//                synchronized (monitor) {
//                    AN_INT--;
//                }
            }
        }
    }
}
