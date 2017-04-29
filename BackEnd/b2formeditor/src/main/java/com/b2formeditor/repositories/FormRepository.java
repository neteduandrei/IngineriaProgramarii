package com.b2formeditor.repositories;

import com.b2formeditor.models.databasemodels.Form;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Dorneanu Dragos-Andrei on 29.04.2017.
 */
public interface FormRepository extends MongoRepository<Form, Integer> {
    List<Form> findAll();

    Form findOne(Integer id);

    List<Form> findByCreatedBy(String createdBy);

    List<Form> findByTitle(String title);

    void delete(Integer id);

}
