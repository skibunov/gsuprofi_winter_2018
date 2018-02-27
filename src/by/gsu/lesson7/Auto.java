package by.gsu.lesson7;


public abstract class Auto<T extends Auto<T>> implements Comparable<T> {
    private int maxSpeed;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public int compareTo(T o) {
        return Integer.compare(maxSpeed, o.getMaxSpeed());
    }
}
