package com.b2formeditor.models.datatransferobjects;

/**
 * Created by Dorneanu Dragos-Andrei on 08.05.2017.
 */
public class FormDTO {
    protected String title;
    protected String description;
    protected QuestionDTO[] fields;

    public String getTitle() {
        return title;
    }

    public FormDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public FormDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public QuestionDTO[] getFields() {
        return fields;
    }

    public FormDTO setFields(QuestionDTO[] fields) {
        this.fields = fields;
        return this;
    }
}
