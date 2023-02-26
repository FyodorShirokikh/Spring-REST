package ru.kata.spring.rest.api.service;

import ru.kata.spring.rest.api.model.Role;
import ru.kata.spring.rest.api.model.User;

import java.util.List;
import java.util.Set;

public interface RoleService {
    List<Role> listRoles(String username);

    List<Role> listOfRoles();

    Set<Role> getNewUserRoles(User user);

    Role findByName(String name);

    void saveRole(Role role);

}
