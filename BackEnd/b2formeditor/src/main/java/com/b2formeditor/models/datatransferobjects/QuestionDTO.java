package com.b2formeditor.models.datatransferobjects;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by Dorneanu Dragos-Andrei on 08.05.2017.
 */
public class QuestionDTO {
    @NotEmpty(message = "Question title should not be empty")
    protected String title;

    protected String description;

    @NotEmpty(message = "Question type should not be empty")
    @Pattern(regexp = "(shortText)|(longText)|(date)|(singleChoice)|(multipleChoice)|(linearScale)",
             message = "Question type should be \"shortText\", \"longText\", \"date\", \"singleChoice\", \"multipleChoice\" or \"linearScale\"")
    protected String type;

    @NotNull(message = "\"required\" field should not be null")
    protected Boolean required;

    protected Object[] value;

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

    public Boolean getRequired() {
        return required;
    }

    public QuestionDTO setRequired(Boolean required) {
        this.required = required;
        return this;
    }

    public Object[] getValue() {
        return value;
    }

    public QuestionDTO setValue(Object[] value) {
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
