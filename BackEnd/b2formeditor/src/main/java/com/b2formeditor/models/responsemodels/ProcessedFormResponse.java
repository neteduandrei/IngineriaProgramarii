package com.b2formeditor.models.responsemodels;

import com.b2formeditor.models.databasemodels.FormResponse;
import com.b2formeditor.models.databasemodels.Question;
import com.b2formeditor.models.intermediatemodels.QuestionResponse;
import com.b2formeditor.services.QuestionService;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */
public class ProcessedFormResponse extends FormResponse {
    protected ProcessedQuestionResponse[] fields;

    void setFields (ProcessedQuestionResponse[] fields) {
        this.fields = fields;
    }

    ProcessedQuestionResponse[] getFields () {
        return fields;
    }

    public ProcessedFormResponse(QuestionService questionService, FormResponse formResponse) {
        setId(((ProcessedFormResponse)formResponse).getId());
        setCreatedAt(formResponse.getCreatedAt());
        setCreatedBy(formResponse.getCreatedBy());
        setFormId(formResponse.getFormId());

        QuestionResponse[] questionResponses = ((ProcessedFormResponse)formResponse).questionResponses;
        this.fields = new ProcessedQuestionResponse[questionResponses.length];
        for (int i = 0; i < questionResponses.length; i++) {
            fields[i] = new ProcessedQuestionResponse(questionService, questionResponses[i]);
        }
    }
}