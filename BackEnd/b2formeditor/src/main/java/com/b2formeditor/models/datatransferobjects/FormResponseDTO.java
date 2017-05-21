package com.b2formeditor.models.datatransferobjects;

import com.b2formeditor.models.databasemodels.Form;
import com.b2formeditor.models.databasemodels.FormResponse;
import com.b2formeditor.models.intermediatemodels.QuestionResponse;

import java.util.List;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */
public class FormResponseDTO extends FormResponse {
    private String formId;
    private QuestionResponseDTO[] fields;

    QuestionResponseDTO[] getFields () {
        return fields;
    }

    void setFields(QuestionResponseDTO[] fields) {
        this.fields = fields;
    }

    public FormResponse toFromResponse() {
        FormResponse response = this;
        QuestionResponse[] questionResponses = new QuestionResponse[fields.length];
        for (int i = 0; i < fields.length; i++) {
            questionResponses[i] = (QuestionResponse) fields[i];
        }

        response.setQuestionResponses(questionResponses);
        return response;
    }
}
