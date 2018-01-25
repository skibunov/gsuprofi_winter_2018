package by.gsu.lesson1.p1;

import by.gsu.lesson1.Taxi;

public class Main {
    public static void main(String[] args) {

        by.gsu.lesson1.p1.Auto auto = new Taxi(34,56,88, 34);
        auto.moveTo(1,2);
        //auto.x = 123;

        by.gsu.lesson1.p1.Auto taxi = new by.gsu.lesson1.p1.Taxi(45,56,67,99);
        taxi.setY(234);
        taxi.moveTo(3,4);
        taxi.print();

        taxi.doSomething();

//        ((Taxi) taxi).passengers = 43;
        //taxi.x = 234;
    }
}
