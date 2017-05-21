package com.b2formeditor.models.databasemodels;

import com.b2formeditor.models.intermediatemodels.QuestionResponse;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import java.util.Date;

/**
 * Created by Dorneanu Dragos-Andrei on 29.04.2017.
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */
@Document(collection = "FormResponses")
public class FormResponse {
    @Id
    protected String id;

    protected String createdBy;

    protected Date createdAt;

    @Valid
    protected String formId;

    protected QuestionResponse[] questionResponses;

    public void setQuestionResponses(QuestionResponse[] questionResponses) {
        this.questionResponses = questionResponses;
    }

    public FormResponse() {
    }

    public FormResponse setId(String id) {
        this.id = id;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getFormId() {
        return formId;
    }

    public FormResponse setFormId(String formId) {
        this.formId = formId;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public FormResponse setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public FormResponse setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }
}
