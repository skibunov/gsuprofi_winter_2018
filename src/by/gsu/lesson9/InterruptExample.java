package by.gsu.lesson9;

import java.util.Random;

public class InterruptExample {

    public static void main(String[] args) {
        Thread t1 = new Thread(new T1());

        t1.start();
        sleepRandom(1500);

        t1.interrupt();

    }


    public static class T1 implements Runnable {

        @Override
        public void run() {
            while (true) {
                System.out.println("Hello!");
                boolean interrupted
                        = Thread.currentThread().isInterrupted() ||
                        sleepRandom(500);
                if (interrupted) {
                    break;
                }

            }
        }
    }

    public static boolean sleepRandom(int to) {
        Random random = new Random();
        int time = random.nextInt(to);


        boolean b = false;
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
            b = true;
        }
        return b;
    }
}
