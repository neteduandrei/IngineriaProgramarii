package com.b2formeditor.services;

import com.b2formeditor.models.databasemodels.Question;
import com.b2formeditor.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dorneanu Dragos-Andrei on 29.04.2017.
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository repository;

    @Override
    public List<Question> getAll() {
        return repository.findAll();
    }

    @Override
    public Question getById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }

    List<Question> findByType(String type) {
        return repository.findByType(type);
    }

    @Override
    public Question save (Question question) {
        List<Question> existing = this.repository.findByTypeAndQuestions(question);
        if (existing.isEmpty()) {
            return this.repository.save(question);
        }
        return existing.get(0);
    }
}
