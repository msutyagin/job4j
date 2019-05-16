package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает сущность счет. Имеет для поля реквизиты(номер счета) и сумма ДС на счете.
 */
public class Account {
    private double value;
    private String requisites;

    public Account() {
    }

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, requisites);
    }

    @Override
    public boolean equals(Object o) {
        Account account = (Account) o;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return Objects.equals(value, account.value)
                && Objects.equals(requisites, account.requisites);
    }


    public String getRequisites() {
        return this.requisites;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
