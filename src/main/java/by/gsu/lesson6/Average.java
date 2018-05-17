package by.gsu.lesson6;

public class Average<T extends Number> {
    T[] data;

    public Average(T[] data) {
        this.data = data;
    }

    public double calculate() {
        double sum = 0;
        for (T t : data) {
            sum += t.doubleValue();
        }
        return sum / data.length;
    }
}
