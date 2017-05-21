package com.b2formeditor.services;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 * Copyright @ Andrei Netedu <andrei.netedu2009@gmail.com>
 */

import com.b2formeditor.models.databasemodels.Form;
import com.b2formeditor.models.databasemodels.FormResponse;
import com.b2formeditor.models.datatransferobjects.FormResponseDTO;
import com.b2formeditor.models.responsemodels.ProcessedForm;
import com.b2formeditor.models.responsemodels.ProcessedFormResponse;
import com.b2formeditor.repositories.FormRepository;
import com.b2formeditor.repositories.FormResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FormResponseServiceImpl implements FormResponseService {
    @Autowired
    private FormResponseRepository responseRepository;

    @Autowired
    private FormRepository formRepository;

//    @Autowired
//    private QuestionRepository questionRepository;

    @Autowired
    private QuestionService questionsService;

    @Autowired
    private EmailService emailService;

//    private boolean check(Response entity) {
//        String[] answers;
//        Question[] questions;
//        ProcessedForm pf;
//        answers = (String[]) entity.getAnswers();
//        pf = new ProcessedForm(questionsService, formRepository.findOne(entity.getFormId()));
//        questions = pf.getFields();
//
//        for (int i = 0; i < answers.length; i++) {
//            String answer, regex, jsonRegex;
//            answer = answers[i];
//
//            if (questions[i].getOptions() == null) return true;
//
//            jsonRegex = questions[i].getOptions().toString();
//
//            String[] equalOperatorParts = jsonRegex.split("=", 2);
//
//            // check for valid regex equals
//            if (equalOperatorParts.length < 2) return true;
//            String[] rightPartVariables = equalOperatorParts[1].split(",|}", 2);
//
//            // check for valid value
//            if (rightPartVariables.length < 1) return true;
//            regex = rightPartVariables[0];
//
//            Pattern pattern = Pattern.compile("^" + regex + "$");
//
//            Matcher matcher = pattern.matcher(answer);
//            if (!matcher.find()) {
//                return false;
//            }
//        }
//        return true;
//    }

    @Override
    public ProcessedFormResponse save(FormResponseDTO entity) {
//        Boolean ok = check(entity);
//
//        if (!ok) {
//            return null;
//        }
        FormResponse formResponse = entity.toFromResponse();
        return new ProcessedFormResponse(questionsService, this.responseRepository.save(formResponse));
    }

    @Override
    public List<ProcessedFormResponse> getAll() {
        return convert(responseRepository.findAll());
    }

    @Override
    public ProcessedFormResponse getById(String id) {
        return new ProcessedFormResponse(questionsService, this.responseRepository.findOne(id));
    }

    @Override
    public void delete(String id) {
        this.responseRepository.delete(id);
    }

    @Override
    public void notifyOwner(String formId) {
        Form databaseForm = formRepository.findOne(formId);
        ProcessedForm form;
        String formOwner, formTitle;

        if (databaseForm != null) {
            form = new ProcessedForm(questionsService, databaseForm);
            formOwner = form.getCreatedBy();
            formTitle = form.getTitle();
            emailService.sendFormResponseNotification(formOwner, formTitle);
        }
    }

    @Override
    public List<ProcessedFormResponse> findByCreatedBy(String owner) {
        return convert(responseRepository.findByCreatedBy(owner));
    }

    protected List<ProcessedFormResponse> convert (List<FormResponse> formResponses) {
        List<ProcessedFormResponse> processedFormResponses = new ArrayList<ProcessedFormResponse>();
        formResponses.forEach((FormResponse formResponse) -> {
            processedFormResponses.add(new ProcessedFormResponse(questionsService, formResponse));
        });
        return processedFormResponses;
    }
}
