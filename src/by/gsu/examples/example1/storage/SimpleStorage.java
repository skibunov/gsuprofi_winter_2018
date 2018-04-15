package by.gsu.examples.example1.storage;

import by.gsu.examples.example1.Storage;

import java.util.ArrayList;
import java.util.List;

public class SimpleStorage<T> implements Storage<T> {

    private List<T> list = new ArrayList<>();

    @Override
    public void add(T element) {
        list.add(element);
    }

    @Override
    public void delete(int id) {
        list.remove(id);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public List<T> getAll() {
       return list;
    }
}
