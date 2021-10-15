package io.unitary.service;

import io.unitary.model.User;

public interface UserService {
    public User getById(Long id);

    public User create(User user);

    public User getByName(String name);

    public Long countUsersByUsername(User user);

}
