package by.gsu.lesson1.p1;

public class Truck extends by.gsu.lesson1.p1.Auto {
    int maxWeight;

    public Truck() {
       super(45,67,78);
    }

    public Truck(int maxSpeed, int x, int y, int maxWeight) {
        super(maxSpeed, x, y);
        this.maxWeight = maxWeight;
    }

    public void doSomething() {
        System.out.println("from truck");
    }
}
