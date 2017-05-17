package com.b2formeditor.models.databasemodels;

import com.b2formeditor.models.datatransferobjects.UserDTO;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


/**
 * Created by Dorneanu Dragos-Andrei on 29.04.2017.
 */
@Document(collection = "Users")
public class User {
    @Id
    private String id;

    @Indexed(unique = true)
    @Email(message = "You must respect an email format. Ex: user@domain.com")
    private String email;

    @NotEmpty(message = "Name should not be empty")
    private String name;

    @Indexed(unique = true)
    private String nickname;

    @NotEmpty(message = "Password should not be empty")
    @Size(min = 6, message = "Password size should be at least 6")
    private String password;

    @NotEmpty(message = "User role should not be empty")
    @Pattern(regexp = "(admin)|(user)", message = "Role should be \"admin\" or \"user\"")
    private String role;

    private String refreshToken;
    private String accessToken;
    private String service;

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
