package com.b2formeditor.models.databasemodels;

import com.b2formeditor.models.datatransferobjects.UserDTO;
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
    protected String id;

    @Indexed(unique = true)
    protected String email;

    @NotBlank
    protected String name;

    @Indexed(unique = true)
    protected String nickname;

    @NotBlank
    @Size(min = 6)
    protected String password;

    @NotBlank
    protected String role;

    protected String refreshToken;
    protected String accessToken;
    protected String service;

    public User() {
    }

    public User(UserDTO userDTO) {
        this.email = userDTO.getEmail();
        this.name = userDTO.getName();
        this.nickname = userDTO.getNickname();
        this.password = userDTO.getPassword();
        this.role = userDTO.getRole();
    }

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

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
