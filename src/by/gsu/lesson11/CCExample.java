package by.gsu.lesson11;

import java.util.*;
import java.util.concurrent.*;

public class CCExample {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(
                Arrays.asList(1,2,3,4,5)
        );

//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//
//
//        for (Integer i : list) {
//            list.add(6);
//        }

        List<Integer> synchronizedList =
                Collections.synchronizedList(list);

        List<Integer> cowList =
                new CopyOnWriteArrayList<>(list);

        Map<String, Integer> cmap =
                new ConcurrentHashMap<>();

        Map<String, Integer> slmap =
                new ConcurrentSkipListMap<>();


        Queue<Integer> qi
                = new ConcurrentLinkedQueue<>();

        Queue<Integer> sq =
                new SynchronousQueue<>();



    }
}
