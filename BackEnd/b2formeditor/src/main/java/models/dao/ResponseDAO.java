package models.dao;

import models.databasemodels.Response;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.ResponseRepository;

import java.util.List;

/**
 * Created by Dorneanu Dragos-Andrei on 29.04.2017.
 */
public class ResponseDAO {
    @Autowired
    private ResponseRepository repository;

    public List<Response> getAllResponses() {
        return repository.findAll();
    }

    public Response saveResponse(Response response) {
        return repository.save(response);
    }

    public void deleteResponse(Response response) {
        repository.delete(response);
    }

    public Response findById(Integer id) {
        return repository.findOne(id);
    }

    public List<Response> findByAuthor(String author) {
        return repository.findByCreated_by(author);
    }

    public List<Response> findByFormId(Integer id) {
        return repository.findByForm_id(id);
    }
}
