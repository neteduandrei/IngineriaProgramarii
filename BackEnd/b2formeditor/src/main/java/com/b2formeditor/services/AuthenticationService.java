package com.b2formeditor.services;

import com.b2formeditor.models.authenticationmodels.AuthenticationCredentials;
import com.b2formeditor.models.authenticationmodels.LoginCredentials;
import com.b2formeditor.models.authenticationmodels.SignUpCredentials;
import com.b2formeditor.models.databasemodels.User;

/**
 * Created by Dorneanu Dragos-Andrei on 30.04.2017.
 */
public interface AuthenticationService extends CrudService<AuthenticationCredentials> {
    String hashPassword(String password);

    boolean equalPassword(String candidatePassword, String databasePassword);

    User createUser(SignUpCredentials credentials);

    boolean validCredentials(LoginCredentials credentials);
}
