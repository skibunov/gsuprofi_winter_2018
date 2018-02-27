package by.gsu.lesson6;

import java.util.Arrays;

public class GenericMain {
    public static void main(String[] args) {
        String arr[] = {"asd", "qwe"};

        SomeBox<? extends Object> obj
                = new SomeBox<String>(arr);


        SomeBox<String> box = new SomeBox<String>(arr);

        String[] data = box.getData();

        Animal[] animals = new Animal[123];

        Arrays.sort(animals);

        Integer i = 678;
        int y = i;
    }
}
