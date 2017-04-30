package com.b2formeditor.repositories;

import com.b2formeditor.models.databasemodels.Form;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * Created by Dorneanu Dragos-Andrei on 29.04.2017.
 */

@Repository
public interface FormRepository extends MongoRepository<Form, String> {
    List<Form> findAll();

    Form findOne(String id);

    List<Form> findByCreatedBy(String createdBy);

    List<Form> findByTitle(String title);

    void delete(String id);

}
