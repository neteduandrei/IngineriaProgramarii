package com.b2formeditor.models.authenticationmodels;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Dorneanu Dragos-Andrei on 30.04.2017.
 */
public abstract class AuthenticationCredentials {
    @NotEmpty
    protected String email;
    @NotEmpty
    protected String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
