package ru.kata.spring.rest.api.repository;

import ru.kata.spring.rest.api.model.User;

import java.util.List;

public interface UserRepository {

    User findByEmail(String email);

    User findById(Long id);

    void save(User user);

    void deleteById(Long id);

    List<User> findAll();

    void saveNew(User user);
}
