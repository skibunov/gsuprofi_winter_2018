package by.gsu.lesson2;

public abstract class Auto implements Movable {
    private int maxSpeed;
    private int x = 34;
    private int y;

    public static final int maxPrice = 56;

    public static void doSomethingStatic() {
        System.out.println("hello from static");
    }

    public static int someVar;

    public abstract void doSomething();




    public Auto(int maxSpeed, int x, int y) {
        this.maxSpeed = maxSpeed;
        this.x = x;
        this.y = y;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    void print() {
        doSomething();
        System.out.println(maxSpeed);
        System.out.println(x);
        System.out.println(y);
    }

    public void moveTo(int x, int y) {
        System.out.println("from auto");
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }

        if (!this.getClass().equals(o.getClass())) {
            return false;
        }

        Auto other = (Auto) o;

        if (this.x != other.x)
            return false;
        if (this.y != other.y)
            return false;

        return true;

    }

    @Override
    public int hashCode() {
        int result = maxSpeed;
        result = 31 * result + x;
        result = 31 * result + y;
        return result;
    }
}
