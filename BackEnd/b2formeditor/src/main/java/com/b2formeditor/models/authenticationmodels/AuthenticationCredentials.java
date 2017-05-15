package com.b2formeditor.models.authenticationmodels;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by Dorneanu Dragos-Andrei on 30.04.2017.
 */
public abstract class AuthenticationCredentials {
    @NotEmpty
    @Email
    protected String email;

    @NotEmpty
    @Size(min = 6)
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
