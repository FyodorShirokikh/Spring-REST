package ru.kata.spring.rest.api.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.rest.api.model.Role;
import ru.kata.spring.rest.api.model.User;
import ru.kata.spring.rest.api.repository.RoleRepository;

import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImp implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> listRoles(String email) {
        return roleRepository.findAll(email);
    }

    @Override
    public Set<Role> getNewUserRoles(User user) {
        return roleRepository.getNewUserRoles(user);
    }

    @Override
    public List<Role> listOfRoles() {
        return roleRepository.listOfRoles();
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Transactional
    public void saveRole(Role role) {
        roleRepository.saveNew(role);
    }

}
