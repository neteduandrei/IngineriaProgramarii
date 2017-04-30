package com.b2formeditor.models.responsemodels;

import com.b2formeditor.models.databasemodels.Form;
import com.b2formeditor.models.databasemodels.Question;
import com.b2formeditor.repositories.QuestionRepository;
import com.b2formeditor.services.QuestionService;

import java.util.Arrays;
import java.util.List;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */
public class ProcessedForm extends Form {
    private Question[] questions;

    public ProcessedForm(QuestionService questionService, Form baseForm) {
        Integer[] base_questions = baseForm.getQuestions();
        questions = new Question[base_questions.length];

        for (int i = 0; i < base_questions.length; i++) {
            questions[i] = questionService.getById(base_questions[i]);
        }
    }

    void commit (QuestionService questionService) {
        Arrays.asList(questions).forEach(questionService::save);
    }

    public Question[] getQuestion() {
        return questions;
    }
}
