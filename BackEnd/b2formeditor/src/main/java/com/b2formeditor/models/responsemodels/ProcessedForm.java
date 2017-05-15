package com.b2formeditor.models.responsemodels;

import com.b2formeditor.models.databasemodels.Form;
import com.b2formeditor.models.databasemodels.Question;
import com.b2formeditor.models.datatransferobjects.FormDTO;
import com.b2formeditor.models.datatransferobjects.QuestionDTO;
import com.b2formeditor.services.QuestionService;

import java.util.Date;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */
public class ProcessedForm extends Form {
    private Question[] fields;

    public ProcessedForm() {
        // default constructor for json
    }

    public ProcessedForm(FormDTO formDTO) {
        QuestionDTO[] dtoFields = formDTO.getFields();

        this.createdAt = new Date();
        this.lastModifiedTime = this.createdAt;
        this.title = formDTO.getTitle();
        this.description = formDTO.getDescription();
        this.font = formDTO.getFont();
        this.fields = new Question[dtoFields.length];

        for (int i = 0; i < dtoFields.length; ++i) {
            this.fields[i] = new Question(dtoFields[i]);
        }
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
        this.lastModifiedTime = baseForm.getLastModifiedTime();
        this.title = baseForm.getTitle();
        this.description = baseForm.getDescription();
        this.questionIds = baseForm.getQuestionIds();
        this.font = baseForm.getFont();
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

    public ProcessedForm setFields(Question[] fields) {
        this.fields = fields;
        return this;
    }

    public Question getQuestionById(String id) {
        for (Question question : fields) {
            if (question.getId().equals(id))
                return question;
        }
        return null;
    }
}
