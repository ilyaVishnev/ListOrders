package ru.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.models.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    List<User> findAllBy();

    User findById(String id);
}
