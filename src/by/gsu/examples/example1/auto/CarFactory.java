package by.gsu.examples.example1.auto;

import by.gsu.examples.example1.Factory;
import by.gsu.examples.example1.util.NumberReader;

import java.io.PrintStream;
import java.util.Scanner;

public class CarFactory implements Factory<Car> {
    private final Scanner sc = new Scanner(System.in);
    private final PrintStream out = System.out;

    @Override
    public Car create() {
        out.println("Taxi(1) or Truck(2) ?");
        int input = NumberReader.getWithLimit(1,2);

        Car result;
        if (input == 1) {
            result = readTaxi();
        } else {
            result = readTruck();
        }

        return result;
    }

    private Taxi readTaxi() {
        out.println("input mark");
        String mark = sc.nextLine();

        out.println("input passengers");
        int passengers = NumberReader.getWithLimit(0, Integer.MAX_VALUE);

        return new Taxi(mark, passengers);
    }

    private Truck readTruck() {
        out.println("input mark");
        String mark = sc.nextLine();

        out.println("is electric? (0/1)");
        int isElectric = NumberReader.getWithLimit(0, 1);

        return new Truck(mark, isElectric == 1);
    }


}
