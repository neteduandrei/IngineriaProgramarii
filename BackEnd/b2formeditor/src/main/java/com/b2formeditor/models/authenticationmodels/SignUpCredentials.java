package com.b2formeditor.models.authenticationmodels;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * Created by Dorneanu Dragos-Andrei on 30.04.2017.
 */
public class SignUpCredentials extends AuthenticationCredentials {
    @Indexed(unique = true)
    private String nickname;

    @NotEmpty(message = "Name should not be empty")
    private String name;

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
}
