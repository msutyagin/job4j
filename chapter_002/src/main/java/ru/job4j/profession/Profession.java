package ru.job4j.profession;

/**
 * Profession Class.
 * @author Maxim Sutyagin (m.sutyagin.m@gmail.com)
 * @since 25.01.19
 * @version 0.1
 */
public class Profession {
    public String name;
    public String profession;

    /**
     * Явно пропишем конструктор по умолчанию.
     */
    public Profession() {
    }

    /**
     * Конструктор класса Profession.
     * @param name - Имя специалиста.
     * @param profession - Профессия специалиста.
     */
    public Profession(String name, String profession) {
        this.name = name;
        this.profession = profession;
    }

    /**
     * Геттер для полученияимени специалиста.
     * @return - Имя специалиста.
     */
    public String getName() {
        return this.name;
    }
}
