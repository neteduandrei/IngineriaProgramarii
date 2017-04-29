package repositories;

import models.databasemodels.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dorneanu Dragos-Andrei on 29.04.2017.
 */

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
    List<User> findAll();

    User findOne(Integer id);

    User save(User user);

    void delete(User user);

    User findByName(String name);

    User findByNickname(String nickname);
}
