package ru.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.models.Order;
import ru.models.User;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
    List<Order> findAllBy();

    Order findById(String id);
}
