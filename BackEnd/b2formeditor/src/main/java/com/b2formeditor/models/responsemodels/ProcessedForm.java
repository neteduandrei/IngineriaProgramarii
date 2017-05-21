package com.b2formeditor.models.responsemodels;

import com.b2formeditor.models.databasemodels.Form;
import com.b2formeditor.models.databasemodels.Question;
import com.b2formeditor.models.datatransferobjects.FormDTO;
import com.b2formeditor.models.datatransferobjects.QuestionDTO;
import com.b2formeditor.models.intermediatemodels.FormQuestion;
import com.b2formeditor.services.QuestionService;

import javax.validation.Valid;
import java.util.Date;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */
public class ProcessedForm extends Form {
    @Valid
    private ProcessedQuestion[] fields;

    public ProcessedForm() {
        // default constructor for json
    }

    public ProcessedForm(QuestionService questionService, Form baseForm) {
        FormQuestion[] formQuestions = baseForm.acquireFromQuestion();
        fields = new ProcessedQuestion[formQuestions.length];

        for (int i = 0; i < formQuestions.length; i++) {
            fields[i] = new ProcessedQuestion(questionService, formQuestions[i]);
        }
        this.id = baseForm.getId();
        this.createdBy = baseForm.getCreatedBy();
        this.createdAt = baseForm.getCreatedAt();
        this.lastModifiedTime = baseForm.getLastModifiedTime();
        this.title = baseForm.getTitle();
        this.description = baseForm.getDescription();
        this.font = baseForm.getFont();
    }

    public ProcessedQuestion[] getFields() {
        return this.fields;
    }

    public void setFields(ProcessedQuestion[] fields) {
        this.fields = fields;
    }

    public ProcessedQuestion getQuestionById(String id) {
        for (ProcessedQuestion question : fields) {
            if (question.getId().equals(id))
                return question;
        }
        return null;
    }
}
