package by.gsu.lesson6;


import java.util.*;

public class CollectionsExample {
    public static void main(String[] args) {
        List<String> strings = new LinkedList<>();

        strings.add("asd");
        strings.add("asd");


        System.out.println(strings);

        Queue<String> q = new LinkedList<>();

        q.add("asdasd");

        String element = q.element();

        Set<String> set = new HashSet<>();


        set.add("qweqwe");

        Map<String, Long> map = new HashMap<>();

        map.put("someKey", 42L);
        map.put("someKey2", 42L);
        map.put("someKey3", 42L);

        Long aLong = map.get("someKey3");
    }
}
