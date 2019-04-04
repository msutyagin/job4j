package ru.job4j.sort;

import java.util.List;
import java.util.Objects;
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
        public String toString() {
            return "User{" +
                    "name'" + name + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            User user = (User) o;
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            return Objects.equals(name, user.name) &&
                    Objects.equals(age, user.age);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
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

