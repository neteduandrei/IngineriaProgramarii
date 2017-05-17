package com.b2formeditor.models.datatransferobjects;

import org.hibernate.validator.constraints.Email;

/**
 * Created by Dorneanu Dragos-Andrei on 16.05.2017.
 */
public class AccountInfoDTO {
    @Email(message = "You must respect an email format. Ex: user@domain.com")
    private String email;

    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
