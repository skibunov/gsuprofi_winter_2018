package by.gsu.examples.example1.util;

import java.util.Scanner;

public class NumberReader {
    private static final Scanner sc = new Scanner(System.in);

    public static int getWithLimit(int from, int to) {
        Integer in = null;
        do {
            try {
                in = Integer.valueOf(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wrong number");
            }
        } while (in == null || in < from || in > to);

        return in;
    }
}
