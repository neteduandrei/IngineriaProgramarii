package com.b2formeditor.models.authenticationmodels;

/**
 * Created by Dorneanu Dragos-Andrei on 30.04.2017.
 */
public class LoginCredentials extends AuthenticationCredentials {

    public LoginCredentials() { }

    public LoginCredentials(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
