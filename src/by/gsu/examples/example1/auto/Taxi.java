package by.gsu.examples.example1.auto;

import java.util.Objects;

@Table(name = "taxi", collation = "cp1251")
public class Taxi extends Car {

//    @Column(name = "Passs", length = 123)
    private int passengers;

    private void test(int randomParamName) {
        System.out.println("it's Taxi test! " + randomParamName);
    }

    public Taxi() {
    }

    public Taxi(String mark, int passengers) {
        super(mark);
        this.passengers = passengers;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Taxi)) return false;
        if (!super.equals(o)) return false;
        Taxi taxi = (Taxi) o;
        return passengers == taxi.passengers;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), passengers);
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "passengers=" + passengers +
                "} " + super.toString();
    }
}
