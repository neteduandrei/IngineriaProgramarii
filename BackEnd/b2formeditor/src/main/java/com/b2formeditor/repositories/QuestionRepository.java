package com.b2formeditor.repositories;

import com.b2formeditor.models.databasemodels.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Dorneanu Dragos-Andrei on 29.04.2017.
 */
public interface QuestionRepository extends MongoRepository<Question, Integer> {
    List<Question> findAll();

    Question save(Question question);

    void delete(Question question);

    Question findOne(Integer id);

    List<Question> findByType(String type);
}
