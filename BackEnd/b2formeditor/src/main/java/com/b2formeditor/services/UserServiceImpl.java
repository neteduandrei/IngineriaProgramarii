package com.b2formeditor.services;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */

import com.b2formeditor.models.databasemodels.User;
import com.b2formeditor.models.responsemodels.ProcessedUser;
import com.b2formeditor.repositories.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public ProcessedUser save(ProcessedUser entity) {
        return (ProcessedUser)this.repository.save(entity);
    }

    @Override
    public List<ProcessedUser> getAll() {
        return (List<ProcessedUser>)(Object)this.repository.findAll();
    }

    @Override
    public ProcessedUser getById(ObjectId id) {
        return (ProcessedUser)this.repository.findOne(id);
    }

    @Override
    public void delete(ObjectId id) {
        this.repository.delete(this.repository.findOne(id));
    }

    public User getByName(String name) {
        return this.repository.findByName(name);
    }

    public void delete(User user) {
        this.repository.delete(user);
    }
}
