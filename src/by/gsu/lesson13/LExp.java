package by.gsu.lesson13;

import by.gsu.lesson9.Account;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LExp {

    static Comparator<Account> cmp = new Comparator<Account>() {
        @Override
        public int compare(Account o1, Account o2) {
            return 0;
        }
    };

    public static void main(String[] args) {


        List<Account> accounts = new ArrayList<>();



        Collections.sort(accounts, cmp);







    }
}
