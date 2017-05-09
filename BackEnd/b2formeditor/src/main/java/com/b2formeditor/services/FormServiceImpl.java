package com.b2formeditor.services;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */

import com.b2formeditor.models.databasemodels.Form;
import com.b2formeditor.models.responsemodels.ProcessedForm;
import com.b2formeditor.repositories.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class FormServiceImpl implements FormService {
    @Autowired
    private
    QuestionService questionService;

    @Autowired
    private FormRepository repository;

    @Override
    public ProcessedForm save(ProcessedForm entity) {
        entity.commit(questionService);
        return this.repository.save(entity);
    }

    @Override
    public List<ProcessedForm> getAll() {
        return processForms(this.repository.findAll());
    }

    @Override
    public ProcessedForm getById(String id) {
        Form form = this.repository.findOne(id);
        if (form != null) {
            return new ProcessedForm(questionService, form);
        }
        return null;
    }

    @Override
    public void delete(String id) {
        this.repository.delete(id);
    }

    @Override
    public List<ProcessedForm> getByUserId(String id) {
        return processForms(this.repository.findByCreatedBy(id));
    }

    private List<ProcessedForm> processForms (List<Form> formList) {
        List<ProcessedForm> processedFormList = new ArrayList<>();
        formList.forEach((Form form) -> processedFormList.add(new ProcessedForm(questionService, form)));
        return processedFormList;
    }

}
