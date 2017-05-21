package com.b2formeditor.models.basemodels;

import com.b2formeditor.models.intermediatemodels.FormQuestion;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */
public abstract class BaseForm {
    @Id
    protected String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    protected String createdBy;
    protected Date createdAt;
    protected Date lastModifiedTime;

    @NotEmpty(message = "Form title should not be empty")
    protected String title;

    protected String description;
    protected String font;
    protected FormQuestion[] formQuestions;

    public String getCreatedBy() {
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

    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFormQuestions(FormQuestion[] formQuestions) {
        this.formQuestions = formQuestions;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }
}

