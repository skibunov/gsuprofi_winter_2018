package by.gsu.lesson13;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SApi {
    public static void main(String[] args) {
        Set<String> roles = new HashSet<>();
        List<User> users = new ArrayList<>();


        for (User user : users) {
            if (user.age > 18) {
                for (Role role : user.roles) {
                    if (role.secured) {
                        roles.add(role.roleName);
                    }
                }
            }
        }

        Set<String> roles1 = users.stream()
                .filter(u -> u.age > 18)
                .flatMap(u -> u.roles.stream())
                .filter(r -> r.secured)
                .map(r -> r.roleName)
                .collect(Collectors.toSet());

        Stream<User> s1 = users.stream();
        Stream<User> s2 = s1.filter(u -> u.age > 18);

//        Stream<User> u7 = s2.filter(user ->
//                user.roles.stream()
//                        .filter(r -> r.secured)
//                        .count() == 0
//        );
//        Stream<String> s3 = s2.map(u -> u.getName());
//        Stream<Set<Role>> setStream = s2.map(u -> u.roles);
        Stream<Role> s4 = s2.flatMap(u -> u.roles.stream());



//        s1.forEach(u -> System.out.println(u));
//        Set<User> set = s1.collect(Collectors.toSet());


    }

    public static class User {
        String name; int age; Set<Role> roles;

        public String getName() {
            return name;
        }
    }

    public static class Role {
        String roleName; boolean secured;
    }
}
