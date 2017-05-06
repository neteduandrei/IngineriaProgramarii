package com.b2formeditor.controllers;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */

import com.b2formeditor.models.responsemodels.ProcessedLoginCredentials;
import com.b2formeditor.models.wrappers.FormTemplateWrapper;
import com.b2formeditor.models.responsemodels.ProcessedForm;
import com.b2formeditor.services.FormService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/v1/forms")
public class FormController {
    @Autowired
    private FormService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ProcessedForm>> getAll(HttpServletRequest request) {
        List<ProcessedForm> forms;
        HttpSession session = request.getSession(true);
        ProcessedLoginCredentials credentials = (ProcessedLoginCredentials) session.getAttribute("credentials");

        if (credentials.getRole().equals("admin")) {
            forms = service.getAll();
            if (forms.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(forms, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<ProcessedForm> get(@PathVariable("id") String id) {
        ProcessedForm form = this.service.getById(id);
        if (form == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(form, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ProcessedForm> addForm(@RequestBody FormTemplateWrapper formTemplate) {
        ProcessedForm savedForm;

        formTemplate.getForm().setCreatedBy(formTemplate.getOwner());

        savedForm = this.service.save(formTemplate.getForm());
        return new ResponseEntity<>(savedForm, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<ProcessedForm> updateForm(@RequestBody FormTemplateWrapper formTemplate) {
        ProcessedForm savedForm;

        formTemplate.getForm().setCreatedBy(formTemplate.getOwner());
        savedForm = this.service.getById(formTemplate.getForm().getId());
        if (savedForm == null) {
            return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
        }
        savedForm = this.service.save(formTemplate.getForm());
        return new ResponseEntity<>(savedForm, HttpStatus.CREATED);
    }
}
