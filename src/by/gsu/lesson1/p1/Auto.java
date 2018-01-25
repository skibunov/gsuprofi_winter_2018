package by.gsu.lesson1.p1;

public abstract class Auto {
    private int maxSpeed;
    private int x = 34;
    private int y;

    public abstract void doSomething();

//    public Auto() {
//    }


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

    void moveTo(int x, int y) {
        System.out.println("from auto");
        this.x = x;
        this.y = y;
    }

}
