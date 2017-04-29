package models.databasemodels;

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
    private Integer id;

    @Indexed(unique = true)
    private String email;

    @NotBlank
    private String name;

    @Indexed(unique = true)
    private String nickname;

    @NotBlank
    @Size(min = 6)
    private String password;

    private Object refresh_token;
    private Object access_token;
    private String service;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Object getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(Object refresh_token) {
        this.refresh_token = refresh_token;
    }

    public Object getAccess_token() {
        return access_token;
    }

    public void setAccess_token(Object access_token) {
        this.access_token = access_token;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
