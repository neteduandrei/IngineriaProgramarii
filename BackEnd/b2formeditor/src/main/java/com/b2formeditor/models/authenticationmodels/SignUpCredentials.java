package com.b2formeditor.models.authenticationmodels;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Dorneanu Dragos-Andrei on 30.04.2017.
 */
public class SignUpCredentials extends AuthenticationCredentials {
    @NotEmpty
    private String nickname;
    @NotEmpty
    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
