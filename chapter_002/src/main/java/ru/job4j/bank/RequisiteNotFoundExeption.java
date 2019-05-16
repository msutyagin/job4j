package ru.job4j.bank;

public class RequisiteNotFoundExeption extends RuntimeException {

    public RequisiteNotFoundExeption(String msg) {
        super(msg);
    }
}
