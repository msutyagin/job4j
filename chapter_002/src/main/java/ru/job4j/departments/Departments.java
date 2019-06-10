package ru.job4j.departments;

import java.util.*;

/**
 * Класс описывает сущность Демартаменты. Содержит вложенный класс Org.
 * @author Максим Сутягин.
 * @version 1.0.
 */

public class Departments {

    /**
     * Вложенный класс Org. Описывает структуру предприятия как список строковых наименовай подразделений.
     */
    public static final class Org implements Comparable<Org> {
        private final List<String> deps;

        /**
         * Конструктор класса.
         */
        public Org(List<String> deps) {
            this.deps = deps;
        }


        @Override
        public boolean equals(Object o) {
            Departments.Org org = (Departments.Org) o;
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            return Objects.equals(deps, org.deps);
        }

        @Override
        public int hashCode() {
            return Objects.hash(deps);
        }

        @Override
        public int compareTo(Org o) {
            return 0;
        }

        @Override
        public String toString() {
            return deps.toString();
        }
    }

    /**
     * Метод преобразует список подразделений подаваемый в виде [k1, k1/sk1/skk1] в список объектов класса Org.
     * @param deps - Входящий список.
     * @return - Преобразованный список.
     */
    public List<Org> convert(List<String> deps) {
        List<Org> result = new ArrayList<>();
        Set<String> temp = new HashSet<>();
        for (String el : deps) {
            if (el.contains("/")) {
                String[] tmp = el.split("/");
                for (int i = 0; i < tmp.length; i++) {
                    temp.add(tmp[i]);
                    result.add(new Org(new ArrayList<>(temp)));
                }
            } else {
                temp = new HashSet<>();
                temp.add(el);
                result.add(new Org(new ArrayList<>(temp)));
            }
        }
        return result;
    }

    /**
     * Метод сортирует список подоразделений по порядку снизу - вверх.
     * @param orgs - Исходный список организаций.
     * @return - Отсортированный список организаций.
     */
    public List<Org> sortAsc(List<Org> orgs) {
        class CompareOrgs implements Comparator<Org> {
            public int compare(Org org1, Org org2) {
                int res = -1;
                if (org1.deps.get(0).compareTo(org2.deps.get(0)) > 0) {
                    res = 1;
                } else if (org1.deps.get(0).compareTo(org2.deps.get(0)) == 0) {
                    res = 0;
                }
                return res;
            }
        }
    CompareOrgs co = new CompareOrgs();
        Collections.sort(orgs, co);
        return orgs;
}

    /**
     * Метод сортирует список подоразделений по порядку сверху - вниз.
     * @param orgs - Исходный список.
     * @return - Отсортированный список.
     */
    public List<Org> sortDesc(List<Org> orgs) {
        class CompareOrgs implements Comparator<Org> {
            public int compare(Org org1, Org org2) {
                int res = 1;
                if (org1.deps.get(0).compareTo(org2.deps.get(0)) > 0) {
                    res = -1;
                } else if (org1.deps.get(0).compareTo(org2.deps.get(0)) == 0) {
                    res = 0;
                }
                return res;
            }
        }
        CompareOrgs co = new CompareOrgs();
        Collections.sort(orgs, co);
        return orgs;
    }
}