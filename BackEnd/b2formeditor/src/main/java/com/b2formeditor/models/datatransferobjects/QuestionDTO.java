package com.b2formeditor.models.datatransferobjects;

/**
 * Created by Dorneanu Dragos-Andrei on 08.05.2017.
 */
public class QuestionDTO {
    protected String title;
    protected String description;
    protected String type;
    protected boolean required;
    protected Object value;
    protected Object options;

    public String getTitle() {
        return title;
    }

    public QuestionDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public QuestionDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getType() {
        return type;
    }

    public QuestionDTO setType(String type) {
        this.type = type;
        return this;
    }

    public boolean isRequired() {
        return required;
    }

    public QuestionDTO setRequired(boolean required) {
        this.required = required;
        return this;
    }

    public Object getValue() {
        return value;
    }

    public QuestionDTO setValue(Object value) {
        this.value = value;
        return this;
    }

    public Object getOptions() {
        return options;
    }

    public QuestionDTO setOptions(Object options) {
        this.options = options;
        return this;
    }
}
