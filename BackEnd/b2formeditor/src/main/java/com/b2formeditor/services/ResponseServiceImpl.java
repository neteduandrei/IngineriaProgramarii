package com.b2formeditor.services;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 * Copyright @ Andrei Netedu <andrei.netedu2009@gmail.com>
 */

import com.b2formeditor.models.databasemodels.Question;
import com.b2formeditor.models.responsemodels.ProcessedForm;
import com.b2formeditor.models.responsemodels.ProcessedResponse;
import com.b2formeditor.repositories.FormRepository;
import com.b2formeditor.repositories.QuestionRepository;
import com.b2formeditor.repositories.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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

    @Autowired
    private QuestionService questionsService;

    private boolean check(ProcessedResponse entity) {
        String[] answers;
        Question[] questions;
        ProcessedForm pf;
        answers = (String[]) entity.getAnswers();
        pf = new ProcessedForm(questionsService, formRepository.findOne(entity.getFormId()));
        questions = pf.getFields();

        for (int i = 0; i < answers.length; i++) {

            String answer, regex, jsonRegex;
            answer = answers[i];

            if(questions[i] == null) return false;

            Boolean required = questions[i].isRequired();
            if(Objects.equals(answer, "")) return !required;

            if (questions[i].getOptions() == null) return true;

            jsonRegex = questions[i].getOptions().toString();

            String[] validationType = jsonRegex.split("validationType=", 2);

            if (validationType.length == 2) {
                String[] unformattedQuestionType = validationType[1].split(",|}", 2);

                // check for valid value
                if (unformattedQuestionType.length < 1) return true;
                String questionType = unformattedQuestionType[0];

                switch(questionType) {
                    case "textField":
                        regex = "[a-zA-Z]*";
                        break;
                    case "textArea":
                        regex = "[a-zA-Z0-9\" ]*";
                        break;
                    case "number":
                        regex = "[0-9]*";
                        break;
                    case "custom":
                        regex = getRegex(jsonRegex);
                        if(regex == null) return true;
                        break;
                    default:
                        return false;
                }
            }
            else {
                regex = getRegex(jsonRegex);
                if(regex == null) return true;
            }

            Pattern pattern = Pattern.compile("^" + regex + "$");

            answer = answer.replace("&quote", "\"");

            Matcher matcher = pattern.matcher(answer);
            if (!matcher.find()) {
                return false;
            }
        }


        return true;
    }

    private static String getRegex(String jsonRegex) {
        String regex;

        String[] equalOperatorParts = jsonRegex.split("regex=", 2);

        // check for valid regex equals
        if (equalOperatorParts.length < 2) return null;
        String[] rightPartVariables = equalOperatorParts[1].split(",|}", 2);

        // check for valid value
        if (rightPartVariables.length < 1) return null;
        regex = rightPartVariables[0];
        return regex;
    }

    @Override
    public ProcessedResponse save(ProcessedResponse entity) {
        Boolean ok = check(entity);

        if (!ok) {
            return null;
        }

        return (ProcessedResponse) this.repository.save(entity);
    }

    @Override
    public List<ProcessedResponse> getAll() {
        return (List<ProcessedResponse>) (Object) this.repository.findAll();
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
