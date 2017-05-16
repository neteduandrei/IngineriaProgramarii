package com.b2formeditor.services;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */

import com.b2formeditor.models.databasemodels.User;
import com.b2formeditor.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public User saveWithoutPasswordHash(User entity) {
        return repository.save(entity);
    }

    @Override
    public User save(User entity) {
        String salt = BCrypt.gensalt();
        String hashedPassword = BCrypt.hashpw(entity.getPassword(), salt);
        entity.setPassword(hashedPassword);
        return repository.save(entity);
    }

    @Override
    public List<User> getAll() {
        return this.repository.findAll();
    }

    @Override
    public User getById(String id) {
        return this.repository.findOne(id);
    }

    @Override
    public void delete(String id) {
        this.repository.delete(this.repository.findOne(id));
    }

    public User getByName(String name) {
        return this.repository.findByName(name);
    }

    public void delete(User user) {
        this.repository.delete(user);
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
