package com.b2formeditor.controllers;

import com.b2formeditor.models.authenticationmodels.LoginCredentials;
import com.b2formeditor.models.authenticationmodels.SignUpCredentials;
import com.b2formeditor.models.responsemodels.ProcessedLoginCredentials;
import com.b2formeditor.services.AuthenticationService;
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
            return new ResponseEntity<>("User already exists", HttpStatus.CONFLICT);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseEntity login(HttpServletRequest request, @Valid @RequestBody LoginCredentials credentials) {
        HttpSession session;
        ProcessedLoginCredentials processedCredentials = service.validCredentials(credentials);

        if (processedCredentials != null) {
            session = request.getSession(true);
            session.setAttribute("credentials", processedCredentials);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid credentials", HttpStatus.NOT_FOUND);
    }
}
