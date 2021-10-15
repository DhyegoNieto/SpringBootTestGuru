package io.unitary.service;

import io.unitary.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyService {

    public String getUserName() {
        return "userOne";
    }

    public List<User> getUserList() {
        List<User> users = new ArrayList<>();
        users.add(new User("Diego", "nieto@mail.com", 1));
        users.add(new User("Deimos", "nietod@mail.com", 2));
        users.add(new User("Lupe", "nietol@mail.com", 3));
        users.add(new User("Nala", "nieton@mail.com", 4));

        return users;
    }
}
