package by.gsu.lesson8;

public class ThreadExamples {
    public static void main(String[] args) throws InterruptedException {


        Thread t1 = new Thread(new CustomThread("T1"));
        Thread t2 = new Thread(new CustomThread("T2"));

//        t1.setDaemon(true);
//        t2.setDaemon(true);



        t1.start();
        t2.start();

        t1.join();
        t2.join();

//        t1.is
//        t1.stop();

        System.out.println("Finish!");
    }

    public static void sleep2(long mil) {
        try {
            Thread.sleep(mil);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
