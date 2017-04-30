package com.b2formeditor.services;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */

import com.b2formeditor.models.responsemodels.ProcessedResponse;
import com.b2formeditor.repositories.ResponseRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseServiceImpl implements ResponseService {
    @Autowired
    private ResponseRepository repository;

    @Override
    public ProcessedResponse save(ProcessedResponse entity) {
        return (ProcessedResponse)this.repository.save(entity);
    }

    @Override
    public List<ProcessedResponse> getAll() {
        return (List<ProcessedResponse>)(Object)this.repository.findAll();
    }

    @Override
    public ProcessedResponse getById(ObjectId id) {
        return (ProcessedResponse) this.repository.findOne(id);
    }

    @Override
    public void delete(ObjectId id) {
        this.repository.delete(id);
    }
}
