package by.gsu.examples.example1.storage;

import by.gsu.examples.example1.Factory;
import by.gsu.examples.example1.util.NumberReader;
import by.gsu.examples.example1.Storage;

import java.util.Arrays;
import java.util.List;

public class SimpleMenu<T> {

    private final Factory<T> factory;
    private final Storage<T> storage;

    public SimpleMenu(Factory<T> factory, Storage<T> storage) {
        this.factory = factory;
        this.storage = storage;
    }



    public void run() {
        exit: while (true) {
            printHelp();
            int choice = NumberReader.getWithLimit(1, 4);
            switch (choice) {
                case 1: {
                    T t = factory.create();
                    storage.add(t);
                    break;
                }
                case 2: {
                    int id = NumberReader.getWithLimit(0, storage.size());
                    storage.delete(id);
                    break;
                }
                case 3: {
                    List<T> all = storage.getAll();
                    for (T t : all) {
                        System.out.println(t);
                    }
                    break;
                }
                case 4: break exit;

            }
        }
    }

    private void printHelp() {
        List<String> menuTitles = Arrays.asList(
                "Add element",
                "Remove by id",
                "Print all",
                "Exit"
        );

        for (int i = 0; i < menuTitles.size(); i++) {
            System.out.println((i + 1) + " " + menuTitles.get(i));
        }
    }
}
