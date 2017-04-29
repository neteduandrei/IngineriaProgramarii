package com.b2formeditor.services;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */

import com.b2formeditor.models.databasemodels.Form;
import com.b2formeditor.models.responsemodels.ProcessedForm;
import com.b2formeditor.repositories.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormServiceImpl implements FormService {
    @Autowired
    private FormRepository repository;

    @Override
    public ProcessedForm save(ProcessedForm entity) {
        return this.repository.save(entity);
    }

    @Override
    public List<ProcessedForm> getAll() {
        return (List<ProcessedForm>)(Object)this.repository.findAll();
    }

    @Override
    public ProcessedForm getById(Integer id) {
        return (ProcessedForm)this.repository.findOne(id);
    }

    @Override
    public void delete(Integer id) {
        this.repository.delete(id);
    }

    @Override
    public List<ProcessedForm> getByUserId(Integer id) {
        return (List<ProcessedForm>)(Object)this.repository.findByUserId(id);
    }

}
