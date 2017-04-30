package com.b2formeditor.repositories;

import com.b2formeditor.models.databasemodels.Question;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dorneanu Dragos-Andrei on 29.04.2017.
 */

@Repository
public interface QuestionRepository extends MongoRepository<Question, ObjectId> {
    List<Question> findAll();

    List<Question> findByTypeAndOptions(Question question);

    Question save(Question question);

    void delete(ObjectId id);

    Question findOne(ObjectId id);

    List<Question> findByType(String type);
}
