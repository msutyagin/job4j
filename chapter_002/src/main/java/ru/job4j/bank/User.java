package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает сущность пользователья. Имеет для поля: имя и пасспорт.
 */
public class User {
    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public User() {
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passport);
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
                && Objects.equals(passport, user.passport);
    }

    public String getPassport() {
        return this.passport;
    }
}
