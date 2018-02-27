package by.gsu.lesson5;

import java.util.Date;

public class SomeMagicMain {
    public static void main(String[] args) {
        for (int i = 0; i < 10_000; i++) {
            test();
        }

        long start = System.currentTimeMillis();
        test();
        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }

    public static int test() {
        int k = 1;
        for (int i = 0; i < 100_000_000; i++) {
            k = k*k;
        }
        return 0;
    }
}
