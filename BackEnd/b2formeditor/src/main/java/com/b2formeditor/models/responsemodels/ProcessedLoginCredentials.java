package com.b2formeditor.models.responsemodels;

import com.b2formeditor.models.authenticationmodels.LoginCredentials;

/**
 * Created by Dorneanu Dragos-Andrei on 06.05.2017.
 */
public class ProcessedLoginCredentials extends LoginCredentials {

    private String role;

    public ProcessedLoginCredentials(LoginCredentials credentials, String userRole) {
        this.email = credentials.getEmail();
        this.password = credentials.getPassword();
        this.role = userRole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
