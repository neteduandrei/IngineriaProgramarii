package com.b2formeditor.models.responsemodels;

import com.b2formeditor.models.databasemodels.Form;
import com.b2formeditor.models.databasemodels.Question;
import com.b2formeditor.services.QuestionService;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */
public class ProcessedForm extends Form {
    private Question[] fields;

    public ProcessedForm() {
        // default constructor for json
    }

    public ProcessedForm(QuestionService questionService, Form baseForm) {
        String[] base_fields = ((ProcessedForm) baseForm).questionIds;
        fields = new Question[base_fields.length];

        for (int i = 0; i < base_fields.length; i++) {
            fields[i] = questionService.getById(base_fields[i]);
        }
        this.id = baseForm.getId();
        this.createdBy = baseForm.getCreatedBy();
        this.createdAt = baseForm.getCreatedAt();
        this.title = baseForm.getTitle();
        this.description = baseForm.getDescription();
    }

    public void commit(QuestionService questionService) {
        String[] scopeQuestionsIds = new String[fields.length];

        for (int i = 0; i < fields.length; i++) {
            String questionId = questionService.save(fields[i]).getId();
            fields[i].setId(questionId);
            scopeQuestionsIds[i] = questionId;
        }

        this.questionIds = scopeQuestionsIds;
    }

    public Question[] getFields() {
        return this.fields;
    }

    public void setFields(Question[] fields) {
        this.fields = fields;
    }

}
