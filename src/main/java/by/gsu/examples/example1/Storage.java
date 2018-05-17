package by.gsu.examples.example1;

import java.util.List;

public interface Storage<T> {
    void add(T element);
    void delete(int id);

    int size();
    List<T> getAll();

}
