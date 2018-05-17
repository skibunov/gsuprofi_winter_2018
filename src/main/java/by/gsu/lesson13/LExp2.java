package by.gsu.lesson13;

import java.io.Serializable;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class LExp2 {
    private static AtomicInteger ai = new AtomicInteger();

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                ai.incrementAndGet();
            }
        };

        Runnable r2 = () -> ai.incrementAndGet();

        Callable<Integer> c1 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 123;
            }
        };

        Callable<Integer> c2 = () -> {
            for (int i = 0; i < 10; i++) {
                ///
            }
            return 324;
        };

        Callable<Integer> c3 = () -> 40 + 2;

        Function<Integer , Integer> f1 =
                new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer + 42;
            }
        };

        Function<Integer , Integer> f2  = i -> i + 42;


        int x = 123;

        Function<Integer, Integer> f3 = i -> i + x;

//        Function<Integer, Integer> f4 = (i) -> {
//            if (true) {
//                x++;
//            }
//            return x;
//        };

        int[] y = new int[1];

        Runnable r5 = () -> {
//            (Runnable & Serializable)
            y[0] = 45;
        };









    }
}
