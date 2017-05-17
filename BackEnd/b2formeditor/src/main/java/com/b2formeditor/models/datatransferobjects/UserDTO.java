package com.b2formeditor.models.datatransferobjects;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Dorneanu on 5/9/2017.
 */
public class UserDTO {
    @Id
    @Email(message = "You must respect an email format. Ex: user@domain.com")
    private String email;

    @NotEmpty(message = "Name should not be empty")
    private String name;

    @Indexed(unique = true)
    private String nickname;

    @NotEmpty(message = "Password should not be empty")
    @Size(min = 6, message = "Password should have at least 6 characters")
    private String password;

    @NotEmpty
    @Pattern(regexp = "(admin)|(user)", message = "Role should be \"admin\" or \"user\"")
    private String role;

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
