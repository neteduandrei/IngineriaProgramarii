package com.b2formeditor.repositories;

import com.b2formeditor.models.databasemodels.Question;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.model.UpdateOptions;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dorneanu Dragos-Andrei on 29.04.2017.
 */

@Repository
public interface QuestionRepository extends MongoRepository<Question, Integer> {
    List<Question> findAll();

    List<Question> findByTypeAndQuestions(Question question);

    Question save(Question question);

    void delete(Question question);

    Question findOne(Integer id);

    List<Question> findByType(String type);
}
