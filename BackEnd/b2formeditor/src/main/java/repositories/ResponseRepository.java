package repositories;

import models.databasemodels.Response;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Dorneanu Dragos-Andrei on 29.04.2017.
 */
public interface ResponseRepository extends MongoRepository<Response, Integer> {
    List<Response> findAll();

    Response save(Response response);

    void delete(Response response);

    Response findOne(Integer id);

    List<Response> findByCreated_by(String created_by);

    List<Response> findByForm_id(Integer form_id);
}
