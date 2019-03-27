package ru.job4j.sort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {

    static class User implements Comparable<User> {
        private String name;
        private String age;

        public User(String name, String age) {
            this.name = name;
            this.age = age;
        }

        public String getName(){
            return this.name;
        }

        public String getAge() {
            return this.age;
        }

        @Override
        public int compareTo(User o) {
            return this.age.compareTo(o.age);
        }
    }

    public Set<User> sort(List<User> input) {
        Set<User> users = new TreeSet<>();
        for (User el : input) {
            users.add(el);
        }
        return users;
    }
}

