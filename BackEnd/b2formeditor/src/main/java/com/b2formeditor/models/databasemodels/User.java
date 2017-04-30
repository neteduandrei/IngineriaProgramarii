package com.b2formeditor.models.databasemodels;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;



/**
 * Created by Dorneanu Dragos-Andrei on 29.04.2017.
 */
@Document(collection = "Users")
public class User {
    @Id
    private String id;

    @Indexed(unique = true)
    private String email;

    @NotBlank
    private String name;

    @Indexed(unique = true)
    private String nickname;

    @NotBlank
    @Size(min = 6)
    private String password;

    private String refreshToken;
    private String accessToken;
    private String service;

    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public User setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Object getRefreshToken() {
        return refreshToken;
    }

    public User setRefreshToken(Object refresh_token) {
        this.refreshToken = refreshToken;
        return this;
    }

    public Object getAccessToken() {
        return accessToken;
    }

    public User setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public String getService() {
        return service;
    }

    public User setService(String service) {
        this.service = service;
        return this;
    }
}
