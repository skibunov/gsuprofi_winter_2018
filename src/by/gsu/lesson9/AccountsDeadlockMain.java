package by.gsu.lesson9;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class AccountsDeadlockMain {
    public static void main(String[] args) throws InterruptedException {
        Account a1 = new Account(1000);
        Account a2 = new Account(2000);

        NewOp op1 = new NewOp(a1, a2, 500);
        NewOp op2 = new NewOp(a2, a1, 500);


        ExecutorService service
                = Executors.newCachedThreadPool();


        List<Future<Boolean>> futures = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                Future<Boolean> future
                        = service.submit(new NewOp(a1, a2, 500));
                futures.add(future);
            } else {
                Future<Boolean> future =
                        service.submit(new NewOp(a2, a1, 500));
                futures.add(future);
            }
        }

        int count = 0, errors = 0;
        for (Future<Boolean> future : futures) {
            Boolean result = false;
            try {
                result = future.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            if (result) {
                count ++;
            } else {
                errors++;
            }

        }

        System.out.println("Great!");

        System.out.println(a1.getAmount());
        System.out.println(a2.getAmount());
        System.out.println(count);
        System.out.println(errors);

        service.shutdown();
    }

    public static class NewOp implements Callable<Boolean> {
        Account from;
        Account to;
        int amount;

        public NewOp(Account from, Account to, int amount) {
            this.from = from;
            this.to = to;
            this.amount = amount;
        }

        @Override
        public Boolean call() {
            Random r = new Random();

            try {
                if (from.getLock().tryLock(
                        r.nextInt(400), TimeUnit.MILLISECONDS)
                        )
                {
                    try {
                        sleepRandom(200);
                        if (to.getLock().tryLock(r.nextInt(400), TimeUnit.MILLISECONDS)) {
                            try {
                                from.withdraw(amount);
                                sleepRandom(200);
                                to.deposit(amount);

                                return true;
                            } finally {
                                to.getLock().unlock();
                            }
                        }

                    } finally {
                        from.getLock().unlock();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return false;
        }
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
                    sleepRandom(1500);
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
