package com.b2formeditor.repositories;

import com.b2formeditor.models.databasemodels.Response;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dorneanu Dragos-Andrei on 29.04.2017.
 */

@Repository
public interface ResponseRepository extends MongoRepository<Response, Integer> {
    List<Response> findAll();

    Response save(Response response);

    void delete(Response response);

    Response findOne(Integer id);

    List<Response> findByCreatedBy(Integer createdBy);

    List<Response> findByFormId(Integer formId);

    void delete(Integer id);
}
