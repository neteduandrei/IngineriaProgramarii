package com.b2formeditor.models.responsemodels;

import com.b2formeditor.models.databasemodels.Question;
import com.b2formeditor.models.intermediatemodels.FormQuestion;
import com.b2formeditor.services.QuestionService;

import javax.validation.constraints.NotNull;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */

/*
Class used for GET requests.
Create from FormQuestion to get the question settings and the required field.
 */
public class ProcessedQuestion extends Question {
    @NotNull(message = "\"required\" field should not be null")
    protected Boolean required;

    public ProcessedQuestion() {
    }

    public String getId() {
        return id;
    }

    public Boolean getRequired () {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }


    protected void setProcessedQuestionProperties (Question question) {
        setOptions(question.getOptions());
        setValues(question.getValues());
        setType(question.getType());
        setTitle(question.getTitle());
        setDescription(question.getDescription());
        setId (((ProcessedQuestion)question).getId());
    }

    public ProcessedQuestion (QuestionService questionService, FormQuestion formQuestion) {
        super();
        Question question = questionService.getById(formQuestion.getQuestionId());
        setProcessedQuestionProperties(question);
        this.setRequired(formQuestion.getRequired());
    }
}
