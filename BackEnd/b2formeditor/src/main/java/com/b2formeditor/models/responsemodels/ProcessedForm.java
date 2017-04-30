package com.b2formeditor.models.responsemodels;

import com.b2formeditor.models.databasemodels.Form;
import com.b2formeditor.models.databasemodels.Question;
import com.b2formeditor.services.QuestionService;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */
public class ProcessedForm extends Form {
    private Question[] questions;

    public ProcessedForm() {
        // default constructor for json
    }

    public ProcessedForm(QuestionService questionService, Form baseForm) {
        String[] base_questions = ((ProcessedForm) baseForm).questionIds;
        questions = new Question[base_questions.length];

        for (int i = 0; i < base_questions.length; i++) {
            questions[i] = questionService.getById(base_questions[i]);
        }
    }

    public void commit (QuestionService questionService) {
        String[] scopeQuestionsIds = new String[questions.length];

        for (int i = 0; i < questions.length; i++) {
            String questionId = questionService.save(questions[i]).getId();
            questions[i].setId(questionId);
            scopeQuestionsIds[i] = questionId;
        }

        this.questionIds = scopeQuestionsIds;
    }

    public Question[] getQuestions() {
        return this.questions;
    }

    public void setQuestions(Question[] questions) {
        this.questions = questions;
    }
}
