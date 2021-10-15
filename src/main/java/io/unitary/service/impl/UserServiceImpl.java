package io.unitary.service.impl;

import io.unitary.model.User;
import io.unitary.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final List<User> users = new ArrayList<>();

    {
        users.add(new User("Diego", "email.com", 1));
        users.add(new User("Fabian", "email.com", 2));
        users.add(new User("Sebastian", "email.com", 3));
        users.add(new User("Laura", "email.com", 4));
        users.add(new User("Rita", "email.com", 6));
        users.add(new User("José", "email.com", 7));
    }

    @Override
    public User getById(Long id) {

        Predicate<User> userPredicate = (user) -> {
            return user.getId() == id;
        };
        return users.stream()
                .filter(userPredicate)
                .findAny()
                .get();
    }

    @Override
    public User create(User user) {
        return new User("Diego", "email.com", 1);
    }

    @Override
    public User getByName(String name) {
        return users.stream()
                .filter(user ->{
                    return user.getName().equalsIgnoreCase(name);
                })
                .findAny()
                .get();
    }

    @Override
    public Long countUsersByUsername(User user) {
        switch(user.getName()) {
            case "José":
                return 1L;
            case "Rita":
                return 2L;
            case "Fabian":
                return 3L;
            default:
                return 0L;
        }
    }
}
