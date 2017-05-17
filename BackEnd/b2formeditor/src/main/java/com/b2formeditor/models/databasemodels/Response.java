package com.b2formeditor.models.databasemodels;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by Dorneanu Dragos-Andrei on 29.04.2017.
 */
@Document(collection = "Responses")
public class Response {
    @Id
    protected String id;

    protected String createdBy;

    protected Date createdAt;

    @NotEmpty(message = "Form ID should not be empty")
    protected String formId;

    protected String[] answers;

    public String getId() {
        return id;
    }

    public Response setId(String id) {
        this.id = id;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Response setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Response setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getFormId() {
        return formId;
    }

    public Response setFormId(String formId) {
        this.formId = formId;
        return this;
    }

    public String[] getAnswers() {
        return answers;
    }

    public Response setAnswers(String[] answers) {
        this.answers = answers;
        return this;
    }
}
