package com.b2formeditor.controllers;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */

import com.b2formeditor.models.responsemodels.ProcessedResponse;
import com.b2formeditor.services.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/responses")
public class ResponseController {
    @Autowired
    private ResponseService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ProcessedResponse>> get() {
        List<ProcessedResponse> forms = this.service.getAll();
        if (forms.isEmpty()) {
            return new ResponseEntity<List<ProcessedResponse>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ProcessedResponse>>(forms, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ProcessedResponse> addForm(@RequestBody ProcessedResponse response) {
        ProcessedResponse savedForm = this.service.save(response);
        return new ResponseEntity<ProcessedResponse>(savedForm, HttpStatus.CREATED);
    }
}
