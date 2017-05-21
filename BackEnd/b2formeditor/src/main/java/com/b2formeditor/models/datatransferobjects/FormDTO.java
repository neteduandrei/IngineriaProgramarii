package com.b2formeditor.models.datatransferobjects;

import com.b2formeditor.models.basemodels.BaseForm;
import com.b2formeditor.models.databasemodels.Form;
import com.b2formeditor.models.databasemodels.Question;
import com.b2formeditor.models.intermediatemodels.FormQuestion;
import com.b2formeditor.models.responsemodels.ProcessedForm;
import com.b2formeditor.models.responsemodels.ProcessedQuestion;
import com.b2formeditor.services.QuestionService;
import com.fasterxml.jackson.databind.deser.Deserializers;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;

/**
 * Created by Dorneanu Dragos-Andrei on 08.05.2017.
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */
public class FormDTO extends BaseForm {
    @Valid
    protected QuestionDTO[] fields;

    public Form commitQuestions (QuestionService questionService) {
        BaseForm baseForm = (BaseForm)this;
        Form form = (Form)baseForm;

        FormQuestion[] scopeFormQuestions = new FormQuestion[fields.length];

        for (int i = 0; i < fields.length; i++) {
            Question question = new Question(fields[i]);

            String questionId = ((ProcessedQuestion)questionService.save(question)).getId();
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
