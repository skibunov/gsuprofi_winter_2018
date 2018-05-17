package by.gsu.lesson14;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyExample {

    public static void main(String[] args) {
        LittleFactory factory = getFactory();
        System.out.println(factory.getClass());
        String x = factory.get();
        System.out.println(x);
    }

    public static LittleFactory getFactory() {

        LittleFactoryImpl original = new LittleFactoryImpl();

        Class<?> ints[] = { LittleFactory.class};
        Object proxy = Proxy.newProxyInstance(
                ProxyExample.class.getClassLoader(),
                ints,
                (proxy1, method, args) -> {
                    System.out.println(" World!");
                    return method.invoke(original, args);
                }


        );

        return (LittleFactory) proxy;
    }

    public static class LittleFactoryImpl implements LittleFactory {

        @Override
        public String get() {
            return "Hello!";
        }
    }

    public interface LittleFactory {
        String get();
    }
}
