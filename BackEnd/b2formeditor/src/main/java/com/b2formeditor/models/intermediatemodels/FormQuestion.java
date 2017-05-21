package com.b2formeditor.models.intermediatemodels;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */
public class FormQuestion {
    private String questionId;
    private Boolean required;


    public String getQuestionId () {
        return questionId;
    }

    public void setQuestionId (String questionId) {
        this.questionId = questionId;
    }

    public Boolean getRequired () {
        return required;
    }

    public void setRequired (Boolean required) {
        this.required = required;
    }

    public FormQuestion (String questionId, Boolean required) {
        setQuestionId(questionId);
        setRequired(required);
    }
}
