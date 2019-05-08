package ru.job4j.sort;

import java.util.*;

/**
 * Сортирует элементы внутреннего класса User различными способами, описаными в соответствующих методах.
 */
public class SortUser {

    /**
     * Внутренний класс User. Описывает сущность User.
     */
    static class User implements Comparable<User> {
        private String name;
        private String age;

        // Конструктор класса
        public User(String name, String age) {
            this.name = name;
            this.age = age;
        }


        public String getName() {
            return this.name;
        }

        public String getAge() {
            return this.age;
        }

        @Override
        public String toString() {
            return "User{"
                    + "name'"
                    + name
                    + '\''
                    +
                    ", age='"
                    + age
                    + '\''
                    +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            User user = (User) o;
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            return Objects.equals(name, user.name)
                    && Objects.equals(age, user.age);
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

    /**
     * Метод сортирует входящий список через добавление его элементов в коллекцию TreeSet.
     * @param input - входящиц список.
     * @return - исходящий TreeSet.
     */
    public Set<User> sort(List<User> input) {
        Set<User> users = new TreeSet<>();
        for (User el : input) {
            users.add(el);
        }
        return users;
    }

    /**
     * Метод сортирует входящий список по количеству знаков в имене от меньшего к большему.
     * @param input - входящий список.
     * @return - отсортированный список.
     */
    public List<User> sortNameLength(List<User> input) {

        /**
         * Компоратор для сортировки по длине имени.
         */
        class CompareNameLength implements Comparator<User> {
            /**
             * Переопределяем метод compare интерфейса Comparator.
             * @param one - первый входящий элемент списка для сравнения.
             * @param two - второй входящий элемент списка для сравнения.
             * @return - 1 или -1 в зависимосьти от результатов сравнения. О не учитываем,
             * так как нам не важно в какой последовательности стоят элементы с одинаковой длинной имени.
             */
            public int compare(User one, User two) {
                return one.getName().length() >= two.getName().length() ? 1 : -1;
            }
        }
        CompareNameLength cnl = new CompareNameLength();
        Collections.sort(input, cnl);
        return input;
    }

    /**
     * Метод сортирует список сначла в лексикографическом порядке а затем по возрасту.
     * @param input - входящий список.
     * @return - отсортированный список.
     */
    public  List<User> sortByAllFields(List<User> input) {

        /**
         * Компоратор для сортировки по обоим полям.
         */
        class CompareAll implements Comparator<User> {
            /**
             * Переопределяем метод compare интерфейса Comparator. Если элементы равны по лексикографическому порядку, тогда сравниваем возраст.
             * @param one - первый входящий элемент списка для сравнения.
             * @param two - второй входящий элемент списка для сравнения.
             * @return - 1 или -1 в зависимосьти от результатов сравнения. О не учитываем,
             * так как нам не важно в какой последовательности стоят элементы с одинаковым возрастом и совпадающем именем.
             */
            public int compare(User one, User two) {
                int res = -1;
                if (one.getName().compareTo(two.getName()) > 0) {
                    res = 1;
                } else if (one.getName().compareTo(two.getName()) == 0) {
                    if (Integer.parseInt(one.getAge()) >= Integer.parseInt(two.getAge())) {
                        res = 1;
                    }
                }
                return res;
            }
        }
        CompareAll all = new CompareAll();
        Collections.sort(input, all);
        return input;
    }
}

