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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public QuestionDTO[] getFields() {
        return fields;
    }

    public void setFields(QuestionDTO[] fields) {
        this.fields = fields;
    }
}
