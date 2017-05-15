package com.b2formeditor.controllers;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */

import com.b2formeditor.models.authenticationmodels.LoginCredentials;
import com.b2formeditor.models.datatransferobjects.FormDTO;
import com.b2formeditor.models.responsemodels.ProcessedForm;
import com.b2formeditor.models.responsemodels.ProcessedLoginCredentials;
import com.b2formeditor.services.FormService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/forms")
public class FormController {
    @Autowired
    private FormService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll(HttpServletRequest request) {
        List<ProcessedForm> forms;
        HttpSession session = request.getSession(true);
        ProcessedLoginCredentials credentials = (ProcessedLoginCredentials) session.getAttribute("credentials");

        if (credentials != null) {
            if (credentials.getRole().equals("admin")) {
                forms = service.getAll();
            } else {
                forms = service.getByCreator(credentials.getEmail());
            }
            if (forms.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(forms, HttpStatus.OK);
        }
        return new ResponseEntity<>("You must be logged in", HttpStatus.FORBIDDEN);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") String id) {
        ProcessedForm form = this.service.getById(id);
        if (form == null) {
            return new ResponseEntity<>("Requested resource not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(form, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addForm(HttpServletRequest request, @Valid @RequestBody FormDTO formDto) {
        ProcessedForm savedForm;
        HttpSession session = request.getSession(true);
        LoginCredentials credentials = (LoginCredentials) session.getAttribute("credentials");

        if (credentials != null) {
            savedForm = new ProcessedForm(formDto);
            savedForm.setCreatedBy(credentials.getEmail());
            savedForm = this.service.save(savedForm);
            return new ResponseEntity<>(savedForm, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("You must be logged in", HttpStatus.FORBIDDEN);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateForm(HttpServletRequest request, @Valid @RequestBody ProcessedForm updatedForm) {
        ProcessedForm savedForm;
        HttpSession session = request.getSession(true);
        LoginCredentials credentials = (LoginCredentials) session.getAttribute("credentials");

        if (credentials != null) {
            savedForm = this.service.getById(updatedForm.getId());
            if (savedForm != null) {
                updatedForm.setCreatedAt(savedForm.getCreatedAt())
                        .setCreatedBy(savedForm.getCreatedBy());
                savedForm = this.service.save(updatedForm);
                return new ResponseEntity<>(savedForm, HttpStatus.CREATED);
            }
            return new ResponseEntity<>("Resource not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("You must be logged in", HttpStatus.FORBIDDEN);
    }
}
