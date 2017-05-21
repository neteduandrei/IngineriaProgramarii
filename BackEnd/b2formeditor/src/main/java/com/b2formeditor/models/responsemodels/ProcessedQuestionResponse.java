package com.b2formeditor.models.responsemodels;

import com.b2formeditor.models.basemodels.BaseQuestion;
import com.b2formeditor.models.databasemodels.Question;
import com.b2formeditor.models.intermediatemodels.QuestionResponse;
import com.b2formeditor.services.QuestionService;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */
public class ProcessedQuestionResponse extends ProcessedQuestion {
    protected String questionId;

    public void setQuestionId (String questionId) {
        this.questionId = questionId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public ProcessedQuestionResponse () {
    }

    public ProcessedQuestionResponse (QuestionService service, QuestionResponse response) {
        Question question = service.getById(response.getQuestionId());
        setProcessedQuestionProperties(question);
    }
}
