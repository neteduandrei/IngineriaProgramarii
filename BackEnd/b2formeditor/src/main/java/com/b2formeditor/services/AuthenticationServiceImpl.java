package com.b2formeditor.services;

import com.b2formeditor.models.authenticationmodels.AuthenticationCredentials;
import com.b2formeditor.models.authenticationmodels.LoginCredentials;
import com.b2formeditor.models.authenticationmodels.SignUpCredentials;
import com.b2formeditor.models.databasemodels.User;
import com.b2formeditor.models.responsemodels.ProcessedLoginCredentials;
import com.b2formeditor.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dorneanu Dragos-Andrei on 30.04.2017.
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private UserRepository repository;

    @Override
    public AuthenticationCredentials save(AuthenticationCredentials credentials) {
        User newUser;
        User user = repository.findByEmail(credentials.getEmail());

        if (credentials instanceof SignUpCredentials) {
            if (user == null) {
                newUser = createUser((SignUpCredentials) credentials);
                repository.save(newUser);
                return credentials;
            }
        }
        return null;
    }

    @Override
    public List<AuthenticationCredentials> getAll() {
        return null;
    }

    @Override
    public AuthenticationCredentials getById(String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public String hashPassword(String password) {
        String salt = BCrypt.gensalt();
        String hashPassword = BCrypt.hashpw(password, salt);
        return hashPassword;
    }

    @Override
    public boolean equalPassword(String candidatePassword, String databasePassword) {
        return BCrypt.checkpw(candidatePassword, databasePassword);
    }

    @Override
    public User createUser(SignUpCredentials credentials) {
        User user = new User();
        user.setEmail(credentials.getEmail())
                .setName(credentials.getName())
                .setNickname(credentials.getNickname())
                .setPassword(hashPassword(credentials.getPassword()))
                .setRole("user");
        return user;
    }

    @Override
    public ProcessedLoginCredentials validCredentials(LoginCredentials credentials) {
        boolean successfulAuthentication = false;
        ProcessedLoginCredentials processedCredentials;

        User user = repository.findByEmail(credentials.getEmail());
        if (user != null) {
            successfulAuthentication = equalPassword(credentials.getPassword(), user.getPassword());
        }
        if(successfulAuthentication) {
            processedCredentials = new ProcessedLoginCredentials(credentials, user.getRole());
            return processedCredentials;
        }
        return null;
    }
}
