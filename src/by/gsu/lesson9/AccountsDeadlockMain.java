package by.gsu.lesson9;

import java.util.Random;

public class AccountsDeadlockMain {
    public static void main(String[] args) throws InterruptedException {
        Account a1 = new Account(1000);
        Account a2 = new Account(2000);

        Op op1 = new Op(a1, a2, 500);
        Op op2 = new Op(a2, a1, 500);

        Thread t1 = new Thread(op1);
        Thread t2 = new Thread(op2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Great!");
    }

    public static class Op implements Runnable {
        Account from;
        Account to;
        int amount;

        public Op(Account from, Account to, int amount) {
            this.from = from;
            this.to = to;
            this.amount = amount;
        }

        @Override
        public void run() {
            synchronized (from) {
                sleepRandom(1500);
                synchronized (to) {
                    from.withdraw(amount);
                    to.deposit(amount);
                }
            }

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
