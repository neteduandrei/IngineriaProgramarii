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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getOptions() {
        return options;
    }

    public void setOptions(Object options) {
        this.options = options;
    }
}
