package models.dao;

import models.databasemodels.Form;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.FormRepository;

import java.util.List;

/**
 * Created by Dorneanu Dragos-Andrei on 29.04.2017.
 */
public class FormDAO {
    @Autowired
    private FormRepository repository;

    public List<Form> getAllResponses() {
        return repository.findAll();
    }

    public Form findById(Integer id) {
        return repository.findOne(id);
    }

    public List<Form> findByAuthor(String author) {
        return repository.findByCreated_by(author);
    }

    public List<Form> findByTitle(String title) {
        return repository.findByTitle(title);
    }
}
