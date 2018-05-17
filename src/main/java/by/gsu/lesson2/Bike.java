package by.gsu.lesson2;

public class Bike extends Object implements Movable {
    @Override
    public void moveTo(int x, int y) {
        System.out.println("bike moved!");
    }
}
