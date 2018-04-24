package by.gsu.lesson14;

import by.gsu.examples.example1.auto.Car;
import by.gsu.examples.example1.auto.Table;
import by.gsu.examples.example1.auto.Taxi;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ClExample {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
//        Class<?> clz = Car.class;
//
//        Taxi taxi = new Taxi();
//        Class<? extends Taxi> aClass = taxi.getClass();
//
//        System.out.println(clz.getCanonicalName());
//        Class<?>[] interfaces = clz.getInterfaces();
//
//        clz.isInterface();


        Class<?> carCls =
                Class.forName("by.gsu.examples.example1.auto.Taxi");

        Constructor<?>[] constructors = carCls.getConstructors();

        Constructor<?> constructor = Arrays.stream(constructors)
                .filter(c -> c.getParameterCount() == 0)
                .findFirst()
                .orElse(null);

        Object o = constructor.newInstance();

        System.out.println(o);

        Method testMethod
                = carCls.getDeclaredMethod("test", int.class);

        testMethod.setAccessible(true);

        Object invokeResult =
                testMethod.invoke(o, 4567);

        Table table = carCls.getAnnotation(Table.class);
        String tableName = table.name();
        System.out.println(tableName);

    }
}
