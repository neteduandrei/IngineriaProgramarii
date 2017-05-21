package com.b2formeditor.models.databasemodels;

import com.b2formeditor.models.basemodels.BaseQuestion;
import com.b2formeditor.models.datatransferobjects.QuestionDTO;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


/**
 * Created by Dorneanu Dragos-Andrei on 29.04.2017.
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */
@Document(collection = "Questions")
public class Question extends BaseQuestion {
    @Id
    protected String id;

    public void setId(String id) {
        this.id = id;
    }

    public Question(QuestionDTO questionDTO) {
        BaseQuestion baseQuestion = (BaseQuestion)questionDTO;
        setDescription(baseQuestion.getDescription());
        setOptions(baseQuestion.getOptions());
        setTitle(baseQuestion.getTitle());
        setType(baseQuestion.getType());
        setOptions(getOptions());
        setValues(getValues());
    }

    public Question() {
    }
}
