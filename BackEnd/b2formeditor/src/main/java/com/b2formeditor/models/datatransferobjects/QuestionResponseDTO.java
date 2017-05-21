package com.b2formeditor.models.datatransferobjects;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */
public class QuestionResponseDTO {
    String questionId;
    private String[] values;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String[] getValues() {
        return values;
    }

    public void setValues(String[] values) {
        this.values = values;
    }
}
