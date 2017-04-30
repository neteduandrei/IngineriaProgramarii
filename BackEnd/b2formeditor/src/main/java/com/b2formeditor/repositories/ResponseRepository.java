package com.b2formeditor.repositories;

import com.b2formeditor.models.databasemodels.Response;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dorneanu Dragos-Andrei on 29.04.2017.
 */

@Repository
public interface ResponseRepository extends MongoRepository<Response, ObjectId> {
    List<Response> findAll();

    Response save(Response response);

    void delete(Response response);

    Response findOne(ObjectId id);

    List<Response> findByCreatedBy(ObjectId createdBy);

    List<Response> findByFormId(ObjectId formId);

    void delete(ObjectId id);
}
