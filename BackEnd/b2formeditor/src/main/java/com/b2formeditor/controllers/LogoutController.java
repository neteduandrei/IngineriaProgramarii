package com.b2formeditor.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Dorneanu Dragos-Andrei on 13.05.2017.
 */
@RestController
@RequestMapping("/v1/logout")
public class LogoutController {

    @RequestMapping(method = RequestMethod.POST)
    private ResponseEntity logout(HttpServletRequest request) {
        request.getSession(true).invalidate();
        return new ResponseEntity(HttpStatus.OK);
    }
}
