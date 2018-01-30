package by.gsu.lesson2;

public class Taxi extends Auto {
    int passengers;

    public void doSomething() {
        System.out.println("from taxi");
    }

    void goForThePassenger() {
        setY(45);
    }

    public Taxi(int maxSpeed, int x, int y, int passengers) {
        super(maxSpeed, x, y);
        System.out.println(Auto.someVar);
        this.passengers = passengers;
    }

    void print() {
        super.print();
        System.out.println(passengers);
    }

    public void moveTo(int anotherX, int anotherY) {
//        x = anotherX;
        System.out.println("from taxi");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Taxi taxi = (Taxi) o;

        return passengers == taxi.passengers;
    }

    @Override
    public int hashCode() {
        return passengers;
    }
}
