package com.b2formeditor.repositories;

import com.b2formeditor.models.databasemodels.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dorneanu Dragos-Andrei on 29.04.2017.
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */

@Repository
public interface QuestionRepository extends MongoRepository<Question, String> {
    List<Question> findAll();

    List<Question> findByTitleAndTypeAndOptions(String title, String type, Object options);

    Question findByTitle(String title);

    Question save(Question question);

    void delete(String id);

    Question findOne(String id);

    List<Question> findByType(String type);
}
