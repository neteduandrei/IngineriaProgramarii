package com.b2formeditor.models.dao;

import com.b2formeditor.models.databasemodels.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.b2formeditor.repositories.UserRepository;

import java.util.List;

/**
 * Created by Dorneanu Dragos-Andrei on 29.04.2017.
 */
public class UserDAO {
    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User findUserById(Integer id) {
        return repository.findOne(id);
    }

    public User saveUser(User user) {
        return repository.save(user);
    }

    public boolean deleteUser(User user) {
        User toDeleteUser = repository.findOne(user.getId());
        if (toDeleteUser == null) {
            return false;
        }
        return true;
    }

    public User findUserByName(String name) {
        return repository.findByName(name);
    }

    public User findUserByNickname(String nickname) {
        return repository.findByNickname(nickname);
    }
}
