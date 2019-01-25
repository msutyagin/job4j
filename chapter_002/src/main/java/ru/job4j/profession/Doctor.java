package ru.job4j.profession;

/**
 * Doctor Class.
 * @author Maxim Sutyagin (m.sutyagin.m@gmail.com)
 * @since 25.01.19
 * @version 0.1
 */
public class Doctor extends Profession {

    /**
     * Лечим пациента.
     * @param patient - Ссылка на объект пациент.
     */
    public void treat(Patient patient) {
    }

    /**
     * Возвращает диагноз пациента
     * @param patient - Ссылка на объект пациент.
     * @return - Диагноз пациента.
     */
    public Diagnose heal(Patient patient) {
        Diagnose diagnose = new Diagnose();
        return diagnose;
    }
}
