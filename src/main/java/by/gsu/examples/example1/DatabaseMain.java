package by.gsu.examples.example1;

import by.gsu.examples.example1.auto.Car;
import by.gsu.examples.example1.auto.CarFactory;
import by.gsu.examples.example1.storage.CarDatabaseStorage;
import by.gsu.examples.example1.storage.SimpleMenu;

public class DatabaseMain {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        Storage<Car> carStorage
                = new CarDatabaseStorage();

        SimpleMenu<Car> menu = new SimpleMenu<>(carFactory, carStorage);

        menu.run();
    }
}
