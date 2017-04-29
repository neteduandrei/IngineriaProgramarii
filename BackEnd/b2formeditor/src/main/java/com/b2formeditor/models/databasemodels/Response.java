package com.b2formeditor.models.databasemodels;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by Dorneanu Dragos-Andrei on 29.04.2017.
 */
@Document(collection = "Responses")
public class Response {
    @Id
    private Integer id;
    private String createdBy;
    private Date createdAt;
    private Integer formId;
    private Object[] answers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreated_by() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getFormId() {
        return formId;
    }

    public void setFormId(Integer formId) {
        this.formId = formId;
    }

    public Object[] getAnswers() {
        return answers;
    }

    public void setAnswers(Object[] answers) {
        this.answers = answers;
    }
}
