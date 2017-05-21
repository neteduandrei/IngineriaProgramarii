package com.b2formeditor.models.datatransferobjects;

import com.b2formeditor.models.basemodels.BaseQuestion;
import com.b2formeditor.models.databasemodels.Question;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by Dorneanu Dragos-Andrei on 08.05.2017.
 */
public class QuestionDTO extends BaseQuestion {
    @NotNull(message = "\"required\" field should not be null")
    protected Boolean required;

    public Boolean getRequired () {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }
}
