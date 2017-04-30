package com.b2formeditor.models.responsemodels;

import com.b2formeditor.models.databasemodels.Form;
import com.b2formeditor.models.databasemodels.Question;
import com.b2formeditor.services.QuestionService;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */
public class ProcessedForm extends Form {
    private Question[] questions;

    public ProcessedForm() {
        // default constructor for json
    }

    public ProcessedForm(QuestionService questionService, Form baseForm) {
        ObjectId[] base_questions = baseForm.getQuestionIds();
        questions = new Question[base_questions.length];

        for (int i = 0; i < base_questions.length; i++) {
            questions[i] = questionService.getById(base_questions[i]);
        }
    }

    public void commit (QuestionService questionService) {
        List<ObjectId> scopeQuestionsIds = new ArrayList<>();
        Arrays.asList(questions).forEach((question) ->{
            ObjectId questionId = questionService.save(question).getId();
            scopeQuestionsIds.add(questionId);
        });
        setQuestionIds((ObjectId[])scopeQuestionsIds.toArray());
    }

    public Question[] getQuestions() {
        return this.questions;
    }

    public void setQuestions(Question[] questions) {
        this.questions = questions;
    }
}
