package by.gsu.lesson2;

public class ObjectMethodsExample {
    public static void main(String[] args) {
        Taxi taxi = new Taxi(11, 2, 3, 4);
        Auto auto = new Taxi(11, 2, 3, 4);

        System.out.println(taxi == auto);
        System.out.println(taxi.equals(auto));

        Color c1 = Color.BLUE;

        System.out.println(Color.valueOf("RED"));

        System.out.println(c1.ordinal());
    }
}
