package by.gsu.lesson15;

public class LazySingleton {

    private static volatile String SOME_DATA;

    public static String getSomeData() {
        if (SOME_DATA == null) {
            synchronized (LazySingleton.class) {
                if (SOME_DATA == null) {
                    SOME_DATA = init();
                }
            }
        }
        return SOME_DATA;
    }


    private static String init() {
        return " asd";
    }
}
