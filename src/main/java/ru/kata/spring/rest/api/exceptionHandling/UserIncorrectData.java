package ru.kata.spring.rest.api.exceptionHandling;

public class UserIncorrectData {
    private String info;

    public UserIncorrectData() {
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
