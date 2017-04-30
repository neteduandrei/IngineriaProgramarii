package com.b2formeditor.controllers;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */

import com.b2formeditor.models.databasemodels.User;
import com.b2formeditor.models.responsemodels.ProcessedUser;
import com.b2formeditor.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ProcessedUser>> get(){
        List<ProcessedUser> forms = this.service.getAll();
        if (forms.isEmpty()){
            return new ResponseEntity<List<ProcessedUser>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ProcessedUser>>(forms, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ProcessedUser> addForm(@RequestBody ProcessedUser response){
        ProcessedUser savedForm = this.service.save(response);
        return new ResponseEntity<ProcessedUser>(savedForm, HttpStatus.CREATED);
    }
}
