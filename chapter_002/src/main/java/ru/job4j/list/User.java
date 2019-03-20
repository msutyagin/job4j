package ru.job4j.list;

public class User {
    private Integer id;
    private String city;

    public User(Integer id, String city) {
        this.id = id;
        this.city = city;
    }

    public Integer getId() {
        return this.id;
    }

    public String getCity() {
        return this.city;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
