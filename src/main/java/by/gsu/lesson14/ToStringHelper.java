package by.gsu.lesson14;

import by.gsu.examples.example1.auto.Taxi;

import java.lang.reflect.Field;

public class ToStringHelper {

    public static String toString(Object o) throws Exception {
        Class<?> cls = o.getClass();

        StringBuilder sb = new StringBuilder();

        while (!Object.class.equals(cls)) {
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(o);

//              TODO skip static  if (field.getModifiers())
                sb.append(field.getName())
                        .append(":")
                        .append(value)
                        .append("; ");
            }

            cls = cls.getSuperclass();
        }


        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        Taxi taxi = new Taxi("audi", 234);

        System.out.println(ToStringHelper.toString(taxi));
    }
}
