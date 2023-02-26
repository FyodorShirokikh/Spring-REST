package ru.kata.spring.rest.api.exceptionHandling;

public class NoSuchUserException extends RuntimeException {
    public NoSuchUserException(String message) {
        super(message);
    }
}
