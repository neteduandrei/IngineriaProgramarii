package com.b2formeditor.controllers;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */

import com.b2formeditor.models.databasemodels.Question;
import com.b2formeditor.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/questions")
public class QuestionController {
    @Autowired
    private QuestionService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Question> get(@RequestParam String title) {
        Question responseQuestion = this.service.getOneByTitle(title);
        if (responseQuestion == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(responseQuestion, HttpStatus.OK);
    }
}
