package by.gsu.lesson11;

public class TLExample {

    public static ThreadLocal<Integer> i = new ThreadLocal<>();

    public static void main(String[] args) {

        i.set(0);

        Thread t1 = new Thread(new T1());
//        t1.setPriority(1000);

        t1.start();
        new Thread(new T2()).start();

    }

    public static class T1 implements Runnable {

        @Override
        public void run() {
//            i = 10;
            i.set(10);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i.get());
        }
    }

    public static class T2 implements Runnable {

        @Override
        public void run() {
//            i = 20;
            i.set(20);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i.get());
        }
    }
}
