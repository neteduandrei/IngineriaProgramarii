package com.b2formeditor.models.datatransferobjects;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

/**
 * Created by Dorneanu on 5/9/2017.
 */
public class ResponseDTO {
    private String[] answers;

    @NotEmpty
    private String formId;

    @NotEmpty
    private String questionId;

    @NotEmpty
    @Pattern(regexp = "(shortText)|(longText)|(date)|(singleChoice)|(multipleChoice)|(linearScale)")
    private String questionType;

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }
}
