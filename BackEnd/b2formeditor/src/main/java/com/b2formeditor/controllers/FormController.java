package com.b2formeditor.controllers;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */

import com.b2formeditor.models.databasemodels.Form;
import com.b2formeditor.models.databasemodels.Question;
import com.b2formeditor.models.responsemodels.ProcessedForm;
import com.b2formeditor.services.FormService;
import com.b2formeditor.services.QuestionService;
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
    public ResponseEntity<List<ProcessedForm>> get() {
        List<ProcessedForm> forms = this.service.getAll();
        if (forms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(forms, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ProcessedForm> addForm(@RequestBody ProcessedForm form) {
        ProcessedForm savedForm = this.service.save(form);
        return new ResponseEntity<>(savedForm, HttpStatus.CREATED);
    }
}
