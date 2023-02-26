package ru.kata.spring.rest.api.service;

import org.springframework.security.core.GrantedAuthority;
import ru.kata.spring.rest.api.model.Role;
import ru.kata.spring.rest.api.model.User;

import java.util.Collection;
import java.util.List;
public interface UserService {
    User findByEmail(String email);
    Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles);
    User get(Long id);
    void save(User user);
    void registerDefaultUser(User user);
    void delete(Long id);
    List<User> showUsers();
    void saveNew(User user);
}
