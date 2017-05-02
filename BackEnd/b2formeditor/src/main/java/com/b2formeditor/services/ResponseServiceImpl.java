package com.b2formeditor.services;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 * Copyright @ Andrei Netedu <andrei.netedu2009@gmail.com>
 */

import com.b2formeditor.models.databasemodels.Form;
import com.b2formeditor.models.responsemodels.ProcessedResponse;
import com.b2formeditor.repositories.FormRepository;
import com.b2formeditor.repositories.QuestionRepository;
import com.b2formeditor.repositories.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ResponseServiceImpl implements ResponseService {
    @Autowired
    private ResponseRepository repository;

    @Autowired
    private FormRepository formRepository;

    @Autowired
    private QuestionRepository questionRepository;

    private boolean check(ProcessedResponse entity) {
        String[] answers, questions;
        answers = (String[]) entity.getAnswers();
        questions = formRepository.findOne(entity.getFormId()).getQuestionIds();

        for(int i = 0; i < answers.length; i++) {
            String answer, regex;
            answer = answers[i];
            regex = (String) questionRepository.findOne(questions[i]).getOptions()[0];

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(answer);
            if (matcher.find()) {
                return false;
            }
        }


        return true;
    }

    @Override
    public ProcessedResponse save(ProcessedResponse entity) {
        Boolean ok = check(entity);

        if(!ok) {
            return null;
        }

        return (ProcessedResponse)this.repository.save(entity);
    }

    @Override
    public List<ProcessedResponse> getAll() {
        return (List<ProcessedResponse>)(Object)this.repository.findAll();
    }

    @Override
    public ProcessedResponse getById(String id) {
        return (ProcessedResponse) this.repository.findOne(id);
    }

    @Override
    public void delete(String id) {
        this.repository.delete(id);
    }
}
