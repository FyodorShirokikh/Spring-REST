package ru.kata.spring.rest.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.rest.api.exceptionHandling.NoSuchUserException;
import ru.kata.spring.rest.api.exceptionHandling.UserIncorrectData;
import ru.kata.spring.rest.api.model.User;
import ru.kata.spring.rest.api.service.UserService;
import java.security.Principal;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class RestUserController {
    private final UserService userService;
    public RestUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/getuser")
    public ResponseEntity<User> getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        String login = auth.getName();
        User user = userService.findByEmail(login);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> apiGetAllUsers() {
        List<User> users = userService.showUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> apiGetOneUser(@PathVariable("id") long id) {
        User user = userService.get(id);
        if (user == null) {
            throw new NoSuchUserException("Нет пользователя с ID = " + id + " в базе данных");
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> apiAddNewUser(@RequestBody User user) {
        userService.registerDefaultUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/users")
    public ResponseEntity<User> apiUpdateUser(@RequestBody User user) {
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public String apiDeleteUser(@PathVariable("id") long id) {
        User user = userService.get(id);
        if (user == null) {
            throw new NoSuchUserException("Нет пользователя с ID = " + id + " в базе данных");
        }
        userService.delete(id);
        return "Пользователь с ID = " + id + " удален!";
    }
}
