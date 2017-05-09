package com.b2formeditor.models.responsemodels;

import com.b2formeditor.models.databasemodels.Response;
import com.b2formeditor.models.datatransferobjects.ResponseDTO;

import java.util.Date;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */
public class ProcessedResponse extends Response {
    private String questionId;
    private  String questionType;

    public ProcessedResponse() { }

    public ProcessedResponse(ResponseDTO responseDTO) {
        this.setQuestionId(responseDTO.getQuestionId())
            .setQuestionType(responseDTO.getQuestionType())
            .setAnswers(responseDTO.getAnswers())
            .setFormId(responseDTO.getFormId())
            .setCreatedAt(new Date());
    }

    public String getQuestionId() {
        return questionId;
    }

    public ProcessedResponse setQuestionId(String questionId) {
        this.questionId = questionId;
        return this;
    }

    public String getQuestionType() {
        return questionType;
    }

    public ProcessedResponse setQuestionType(String questionType) {
        this.questionType = questionType;
        return this;
    }
}
