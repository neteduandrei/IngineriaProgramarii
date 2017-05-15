package com.b2formeditor.models.databasemodels;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by Dorneanu Dragos-Andrei on 29.04.2017
 */

@Document(collection = "Forms")
public class Form {
    @Id
    protected String id;
    protected String createdBy;
    protected Date createdAt;

    @NotBlank
    protected String title;
    protected String description;
    protected String[] questionIds;
    protected String font;

    public String getId() {
        return id;
    }

    public Form setId(String id) {
        this.id = id;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Form setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Form setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Form setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Form setDescription(String description) {
        this.description = description;
        return this;
    }

    public String[] getQuestionIds() {
        return questionIds;
    }

    public void setQuestionIds(String[] questionIds) {
        this.questionIds = questionIds;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }
}
