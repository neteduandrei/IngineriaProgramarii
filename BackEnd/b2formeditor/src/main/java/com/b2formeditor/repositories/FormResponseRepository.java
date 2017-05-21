package com.b2formeditor.repositories;

import com.b2formeditor.models.databasemodels.FormResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dorneanu Dragos-Andrei on 29.04.2017.
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */

@Repository
public interface FormResponseRepository extends MongoRepository<FormResponse, String> {
    List<FormResponse> findAll();

    FormResponse save(FormResponse response);

    void delete(FormResponse response);

    FormResponse findOne(String id);

    List<FormResponse> findByCreatedBy(String createdBy);

    List<FormResponse> findByFormId(String formId);

    void delete(String id);
}
