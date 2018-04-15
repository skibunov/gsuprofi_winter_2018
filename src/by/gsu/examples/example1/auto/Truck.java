package by.gsu.examples.example1.auto;

import java.util.Objects;

public class Truck extends Car {
    private boolean electric;

    public Truck() {
    }

    public Truck(String mark, boolean electric) {
        super(mark);
        this.electric = electric;
    }

    public boolean isElectric() {
        return electric;
    }

    public void setElectric(boolean electric) {
        this.electric = electric;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Truck)) return false;
        if (!super.equals(o)) return false;
        Truck truck = (Truck) o;
        return electric == truck.electric;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), electric);
    }

    @Override
    public String toString() {
        return "Truck{" +
                "electric=" + electric +
                "} " + super.toString();
    }
}
