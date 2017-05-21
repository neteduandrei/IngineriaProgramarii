package com.b2formeditor.models.datatransferobjects;

import com.b2formeditor.models.basemodels.BaseForm;
import com.b2formeditor.models.databasemodels.Form;
import com.b2formeditor.models.databasemodels.Question;
import com.b2formeditor.models.intermediatemodels.FormQuestion;
import com.b2formeditor.models.responsemodels.ProcessedQuestion;
import com.b2formeditor.services.QuestionService;

import javax.validation.Valid;

/**
 * Created by Dorneanu Dragos-Andrei on 08.05.2017.
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */
public class FormDTO extends BaseForm {
    @Valid
    protected QuestionDTO[] fields;

    public Form commitQuestions (QuestionService questionService) {
        Form form = new Form();
        form.setCreatedBy (getCreatedBy ());
        form.setCreatedAt (getCreatedAt ());
        form.setLastModifiedTime (getLastModifiedTime ());
        form.setTitle (getTitle ());
        form.setDescription (getDescription ());
        form.setFont (getFont ());

        FormQuestion[] scopeFormQuestions = new FormQuestion[fields.length];

        for (int i = 0; i < fields.length; i++) {
            Question question = new Question(fields[i]);

            String questionId = questionService.save(question).acquireId();
            scopeFormQuestions[i] = new FormQuestion(questionId, fields[i].getRequired());
        }

        form.setFormQuestions(scopeFormQuestions);

        return form;
    }

    public void setFields (QuestionDTO[] fields) {
        this.fields = fields;
    }

    public QuestionDTO[] getFields () {
        return fields;
    }
}
