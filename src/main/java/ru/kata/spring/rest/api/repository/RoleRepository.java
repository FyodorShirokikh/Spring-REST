package ru.kata.spring.rest.api.repository;

import ru.kata.spring.rest.api.model.Role;
import ru.kata.spring.rest.api.model.User;

import java.util.List;
import java.util.Set;


public interface RoleRepository {
    Role findByName(String name);

    List<Role> findAll(String username);

    Set<Role> getNewUserRoles(User user);

    List<Role> listOfRoles();

    void saveNew(Role role);

}
