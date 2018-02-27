package by.gsu.lesson7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SomeBox<T> {

    public void test(Collection<Integer> ints) {
        Integer next = ints.iterator().next();
        System.out.println(next);
    }

    public void test(List<String> strings) {
        String s = strings.get(0);
        System.out.println(s);
    }

    public static void main(String[] args) {
        SomeBox box = new SomeBox();

        Collection<String> str = new ArrayList<>();
        str.add("asd");
        box.test(str);



    }
}
