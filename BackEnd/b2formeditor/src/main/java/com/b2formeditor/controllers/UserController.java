package com.b2formeditor.controllers;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */

import com.b2formeditor.models.authenticationmodels.LoginCredentials;
import com.b2formeditor.models.databasemodels.User;
import com.b2formeditor.models.datatransferobjects.AccountInfoDTO;
import com.b2formeditor.models.datatransferobjects.UserDTO;
import com.b2formeditor.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> get() {
        List<User> forms = this.service.getAll();
        if (forms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(forms, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> addUser(@Valid @RequestBody UserDTO userDTO) {
        User newUser = new User(userDTO);
        User savedUser = this.service.save(newUser);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/updateaccount", method = RequestMethod.PATCH)
    public ResponseEntity updateAccountInfo(HttpServletRequest request, @Valid @RequestBody AccountInfoDTO accountDTO) {
        HttpSession session = request.getSession(true);
        LoginCredentials credentials = (LoginCredentials) session.getAttribute("credentials");
        String newEmail, newName;
        User user;

        if (credentials != null) {
            newEmail = accountDTO.getEmail();
            newName = accountDTO.getName();
            user = service.findByEmail(credentials.getEmail());
            if (newEmail != null) {
                user.setEmail(newEmail);
                credentials.setEmail(newEmail);
                session.setAttribute("credentials", credentials);
            }
            if (newName != null) {
                user.setName(newName);
            }
            user = service.saveWithoutPasswordHash(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>("You must be logged in", HttpStatus.FORBIDDEN);
    }

    @RequestMapping(value = "/changepassword", method = RequestMethod.PATCH)
    public ResponseEntity changePassword(HttpServletRequest request, @Size(min = 6) @RequestBody String newPassword) {
        HttpSession session = request.getSession(true);
        LoginCredentials credentials = (LoginCredentials) session.getAttribute("credentials");
        User user;

        if (credentials != null) {
            user = service.findByEmail(credentials.getEmail());
            user.setPassword(newPassword);
            user = service.save(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>("You must be logged in", HttpStatus.FORBIDDEN);
    }
}
