package by.gsu.lesson2;

public class Main {
    public static void main(String[] dfghj) {

        Auto.someVar = 45;

        Auto auto = new Taxi(34,56,88, 34);
        auto.moveTo(1,2);
        //auto.x = 123;

        Auto taxi = new Taxi(45,56,67,99);
        taxi.setY(234);
        taxi.moveTo(3,4);
        taxi.print();

        taxi.doSomething();

        Movable movable = taxi;

        moveSomething(taxi);
        Bike bike = new Bike();
        moveSomething(bike);


//        ((Taxi) taxi).passengers = 43;
        //taxi.x = 234;
    }

    public static void moveSomething(Movable movable) {
        movable.moveTo(234,45);
    }
}
