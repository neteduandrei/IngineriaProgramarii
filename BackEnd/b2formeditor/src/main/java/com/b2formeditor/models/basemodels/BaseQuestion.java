package com.b2formeditor.models.basemodels;

import com.b2formeditor.models.datatransferobjects.QuestionDTO;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */
public abstract class BaseQuestion {
    @NotEmpty(message = "Question title should not be empty")
    protected String title;

    protected String description;

    @NotEmpty(message = "Question type should not be empty")
    @Pattern(regexp = "(shortText)|(longText)|(date)|(singleChoice)|(multipleChoice)|(linearScale)",
            message = "Question type should be \"shortText\", \"longText\", \"date\", \"singleChoice\", \"multipleChoice\" or \"linearScale\"")
    protected String type;

    protected Object[] values;

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

    public Object[] getValues() {
        return values;
    }

    public void setValues(Object[] value) {
        this.values = value;
    }

    public Object getOptions() {
        return options;
    }

    public void setOptions(Object options) {
        this.options = options;
    }
}
