package by.gsu.lesson7;

import java.util.ArrayList;
import java.util.List;

public class NumberCollectionsExample {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();

        new ArrayList<>(ints);

        List<Number> out = new ArrayList<>(10);
//        List<Number> s = new ArrayList<Integer>();
        someLogic(ints, out);
    }

    public static void someLogic(
            List<? extends Number> in,
            List<? super Number> out
    ) {
        for (int i = 0; i < in.size(); i++) {
            out.add(in.get(i));
        }
    }
}
