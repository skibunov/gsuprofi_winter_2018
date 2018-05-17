package by.gsu.lesson6;

import java.io.Serializable;
import java.util.Arrays;

public class SomeBox<T> {

    private T[] data;

    public SomeBox(T[] data) {
        this.data = data;
    }

    public T[] getData() {
        return data;
    }

    public void print() {
        System.out.println(
                Arrays.toString(data)
        );
    }

    public void printOne() {
        System.out.println(
                data[0]
        );
    }
}
