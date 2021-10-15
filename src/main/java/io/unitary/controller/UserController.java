package io.unitary.controller;

import io.unitary.model.User;
import io.unitary.service.MyService;
import io.unitary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/users/")
public class UserController {

    private final UserService userService;

    private final MyService myService;

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping("/{username}")
    public User getByName(@PathVariable String username) {
        return userService.getByName(username);
    }

    @GetMapping
    public Long getCountByName(@RequestBody User user) {

        Long longOption = userService.countUsersByUsername(user);

        if(longOption == 0L) {
            myService.getUserList();
        } else {
            userService.getById(longOption);
        }

        return longOption;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = null;
        if(user != null) {
            newUser = userService.create(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
