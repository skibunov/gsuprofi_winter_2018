package by.gsu.lesson1.p1;

public class Taxi extends by.gsu.lesson1.p1.Auto {
    int passengers;

    public void doSomething() {
        System.out.println("from taxi");
    }

    void goForThePassenger() {
        setY(45);
    }

    public Taxi(int maxSpeed, int x, int y, int passengers) {
        super(maxSpeed, x, y);
        this.passengers = passengers;
    }

    void print() {
        super.print();
        System.out.println(passengers);
    }

    void moveTo(int anotherX, int anotherY) {
//        x = anotherX;
        System.out.println("from taxi");
    }
}
