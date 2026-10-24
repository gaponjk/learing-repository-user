package com.haponenka.app.repository.impl;

import com.haponenka.app.model.User;
import com.haponenka.app.repository.UserRepository;

import java.util.*;

public class InMemoryUserRepository implements UserRepository {
    private final Map<Long, User> users = new HashMap<>();

    public InMemoryUserRepository() {
    }

    @Override
    public void save(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void deleteById(Long id) {
        users.remove(id);
    }
}
