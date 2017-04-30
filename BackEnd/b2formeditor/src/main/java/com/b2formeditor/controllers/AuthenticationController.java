package com.b2formeditor.controllers;

import com.b2formeditor.models.authenticationmodels.LoginCredentials;
import com.b2formeditor.models.authenticationmodels.SignUpCredentials;
import com.b2formeditor.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by Dorneanu Dragos-Andrei on 30.04.2017.
 */
@RestController
@RequestMapping("/v1/authentication")
public class AuthenticationController {
    @Autowired
    private AuthenticationService service;

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public ResponseEntity singUp(@Valid @RequestBody SignUpCredentials credentials) {
        if (service.save(credentials) == null) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseEntity login(@Valid @RequestBody LoginCredentials credentials) {
        if (service.validCredentials(credentials)) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
