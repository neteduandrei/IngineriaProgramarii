package com.b2formeditor.controllers;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */

import com.b2formeditor.models.databasemodels.Form;
import com.b2formeditor.services.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/forms")
public class FormController {
    @Autowired
    private FormService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Form>> get(){
        List<Form> forms = this.service.getAll();
        if (forms.isEmpty()){
            return new ResponseEntity<List<Form>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Form>>(forms, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Form> addForm(@RequestBody Form form){
        Form savedForm = this.service.save(form);
        return new ResponseEntity<Form>(savedForm, HttpStatus.CREATED);
    }
}
