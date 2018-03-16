package by.gsu.lesson9;

public class Account {
    private int amount;

    public Account(int amount) {
        this.amount = amount;
    }

    void deposit(int d) {
        amount += d;
    }

    void withdraw(int d) {
        if (amount < d) {
            throw new
                    IllegalArgumentException("Not enought money!");
        }
        amount -= d;
    }
}
