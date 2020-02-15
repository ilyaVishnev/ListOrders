package ru.dao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dao.repositories.UserRepository;
import ru.models.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAllBy();
    }

    public User findUserById(String id) {
        return userRepository.findById(id);
    }
}
