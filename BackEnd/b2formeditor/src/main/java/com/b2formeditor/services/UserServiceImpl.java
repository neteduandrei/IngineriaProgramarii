package com.b2formeditor.services;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */

import com.b2formeditor.models.databasemodels.User;
import com.b2formeditor.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public User save(User entity) {
        return this.repository.save(entity);
    }

    @Override
    public List<User> getAll() {
        return this.repository.findAll();
    }

    @Override
    public User getById(Integer id) {
        return this.repository.findOne(id);
    }

    @Override
    public void delete(Integer id) {
        this.repository.delete(this.repository.findOne(id));
    }

    public User getByName(String name) {
        return this.repository.findByName(name);
    }

    public void delete(User user) {
        this.repository.delete(user);
    }
}
