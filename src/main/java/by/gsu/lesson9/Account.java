package by.gsu.lesson9;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private Lock lock = new ReentrantLock();
    private int amount;

    public Account(int amount) {
        this.amount = amount;
    }

    public Lock getLock() {
        return lock;
    }

    void deposit(int d) {
        amount += d;
    }

    public int getAmount() {
        return amount;
    }

    void withdraw(int d) {
        if (amount < d) {
            throw new
                    IllegalArgumentException("Not enought money!");
        }
        amount -= d;
    }
}
