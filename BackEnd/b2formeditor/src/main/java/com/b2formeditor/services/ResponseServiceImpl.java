package com.b2formeditor.services;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */

import com.b2formeditor.models.databasemodels.Response;
import com.b2formeditor.repositories.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseServiceImpl implements ResponseService {
    @Autowired
    private ResponseRepository repository;

    @Override
    public Response save(Response entity) {
        return this.repository.save(entity);
    }

    @Override
    public List<Response> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Response getById(Integer id) {
        return this.repository.findOne(id);
    }

    @Override
    public void delete(Integer id) {
        this.repository.delete(id);
    }
}
