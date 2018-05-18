package by.gsu.examples.example1.auto;

import java.io.Serializable;
import java.util.Objects;

public abstract class Car implements Comparable<Car>, Cloneable, Serializable {
    private Integer id;
    private String mark;

    private static long serialVersionUID = 0;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Car() {
    }

    public Car(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int compareTo(Car o) {
        String mark1 = this.getMark() != null ? this.getMark() : "";
        String mark2 = o != null && o.getMark() != null ? o.getMark() : "";
        return mark1.compareToIgnoreCase(mark2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(mark, car.mark);
    }

    @Override
    public int hashCode() {

        return Objects.hash(mark);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                "mark='" + mark + '\'' +
                '}';
    }
}
